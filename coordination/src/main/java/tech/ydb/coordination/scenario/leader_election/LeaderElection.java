package tech.ydb.coordination.scenario.leader_election;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicLong;

import com.google.protobuf.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tech.ydb.coordination.CoordinationClient;
import tech.ydb.coordination.SemaphoreDescription;
import tech.ydb.coordination.SemaphoreSession;
import tech.ydb.coordination.SessionRequest;
import tech.ydb.coordination.observer.CoordinationSessionObserver;
import tech.ydb.coordination.scenario.WorkingScenario;
import tech.ydb.coordination.session.CoordinationSession;
import tech.ydb.coordination.settings.ScenarioSettings;
import tech.ydb.core.Status;

/**
 * @author Kirill Kurdyukov
 */
public class LeaderElection extends WorkingScenario {

    private static final Logger logger = LoggerFactory.getLogger(LeaderElection.class);
    private static final int LIMIT_TOKENS_SEMAPHORE = 1;
    private static final int COUNT_TOKENS = 1;

    private final AtomicLong epochLeader = new AtomicLong();

    public LeaderElection(
            CoordinationClient client,
            ScenarioSettings settings,
            String coordinationNodePath,
            String ticket,
            LeaderElectionObserver observer
    ) {
        super(client, settings, coordinationNodePath);

        start(
                new CoordinationSessionObserver() {
                    @Override
                    public void onAcquireSemaphoreResult(boolean acquired, Status status) {
                        epochLeader.set(currentCoordinationSession.get().getSessionId());

                        observer.onNext(ticket);
                    }

                    @Override
                    public void onAcquireSemaphorePending() {
                        describeSemaphore();
                    }

                    @Override
                    public void onDescribeSemaphoreResult(SemaphoreDescription semaphoreDescription, Status status) {
                        if (status.isSuccess()) {
                            SemaphoreSession semaphoreSessionLeader = semaphoreDescription.getOwnersList().get(0);

                            if (semaphoreSessionLeader.getSessionId() != epochLeader.get()) {
                                epochLeader.set(semaphoreSessionLeader.getSessionId());

                                observer.onNext(
                                        semaphoreSessionLeader.getData()
                                                .toString(StandardCharsets.UTF_8)
                                );
                            }
                        } else {
                            logger.error("Error describer result from leader election session, status: {}", status);
                        }
                    }

                    @Override
                    public void onDescribeSemaphoreChanged(boolean dataChanged, boolean ownersChanged) {
                        if (ownersChanged) {
                            describeSemaphore();
                        }
                    }

                    @Override
                    public void onFailure(Status status) {
                        logger.error("Fail from leader election session: {}", status);
                    }

                    @Override
                    public void onSessionStarted() {
                        CoordinationSession coordinationSession = currentCoordinationSession.get();

                        logger.info("Starting leader election session, sessionId: {}",
                                coordinationSession.getSessionId());

                        coordinationSession.sendCreateSemaphore(
                                SessionRequest.CreateSemaphore.newBuilder()
                                        .setName(settings.getSemaphoreName())
                                        .setLimit(LIMIT_TOKENS_SEMAPHORE)
                                        .build()
                        );

                        coordinationSession.sendAcquireSemaphore(
                                SessionRequest.AcquireSemaphore.newBuilder()
                                        .setName(settings.getSemaphoreName())
                                        .setCount(COUNT_TOKENS)
                                        .setTimeoutMillis(-1)
                                        .setData(ByteString.copyFrom(ticket.getBytes(StandardCharsets.UTF_8)))
                                        .build()
                        );
                    }
                }
        );
    }

    public long epochLeader() {
        return epochLeader.get();
    }

    private void describeSemaphore() {
        currentCoordinationSession.get().sendDescribeSemaphore(
                SessionRequest.DescribeSemaphore.newBuilder()
                        .setName(settings.getSemaphoreName())
                        .setWatchOwners(true)
                        .setIncludeOwners(true)
                        .build()
        );
    }
}
