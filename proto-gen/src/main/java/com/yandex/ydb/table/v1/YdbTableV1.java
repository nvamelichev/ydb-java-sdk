// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/grpc/ydb_table_v1.proto

package tech.ydb.table.v1;

public final class YdbTableV1 {
  private YdbTableV1() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)kikimr/public/api/grpc/ydb_table_v1.pr" +
      "oto\022\014Ydb.Table.V1\032(kikimr/public/api/pro" +
      "tos/ydb_table.proto2\323\r\n\014TableService\022R\n\r" +
      "CreateSession\022\037.Ydb.Table.CreateSessionR" +
      "equest\032 .Ydb.Table.CreateSessionResponse" +
      "\022R\n\rDeleteSession\022\037.Ydb.Table.DeleteSess" +
      "ionRequest\032 .Ydb.Table.DeleteSessionResp" +
      "onse\022F\n\tKeepAlive\022\033.Ydb.Table.KeepAliveR" +
      "equest\032\034.Ydb.Table.KeepAliveResponse\022L\n\013" +
      "CreateTable\022\035.Ydb.Table.CreateTableReque",
      "st\032\036.Ydb.Table.CreateTableResponse\022F\n\tDr" +
      "opTable\022\033.Ydb.Table.DropTableRequest\032\034.Y" +
      "db.Table.DropTableResponse\022I\n\nAlterTable" +
      "\022\034.Ydb.Table.AlterTableRequest\032\035.Ydb.Tab" +
      "le.AlterTableResponse\022F\n\tCopyTable\022\033.Ydb" +
      ".Table.CopyTableRequest\032\034.Ydb.Table.Copy" +
      "TableResponse\022I\n\nCopyTables\022\034.Ydb.Table." +
      "CopyTablesRequest\032\035.Ydb.Table.CopyTables" +
      "Response\022R\n\rDescribeTable\022\037.Ydb.Table.De" +
      "scribeTableRequest\032 .Ydb.Table.DescribeT",
      "ableResponse\022[\n\020ExplainDataQuery\022\".Ydb.T" +
      "able.ExplainDataQueryRequest\032#.Ydb.Table" +
      ".ExplainDataQueryResponse\022[\n\020PrepareData" +
      "Query\022\".Ydb.Table.PrepareDataQueryReques" +
      "t\032#.Ydb.Table.PrepareDataQueryResponse\022[" +
      "\n\020ExecuteDataQuery\022\".Ydb.Table.ExecuteDa" +
      "taQueryRequest\032#.Ydb.Table.ExecuteDataQu" +
      "eryResponse\022a\n\022ExecuteSchemeQuery\022$.Ydb." +
      "Table.ExecuteSchemeQueryRequest\032%.Ydb.Ta" +
      "ble.ExecuteSchemeQueryResponse\022[\n\020BeginT",
      "ransaction\022\".Ydb.Table.BeginTransactionR" +
      "equest\032#.Ydb.Table.BeginTransactionRespo" +
      "nse\022^\n\021CommitTransaction\022#.Ydb.Table.Com" +
      "mitTransactionRequest\032$.Ydb.Table.Commit" +
      "TransactionResponse\022d\n\023RollbackTransacti" +
      "on\022%.Ydb.Table.RollbackTransactionReques" +
      "t\032&.Ydb.Table.RollbackTransactionRespons" +
      "e\022g\n\024DescribeTableOptions\022&.Ydb.Table.De" +
      "scribeTableOptionsRequest\032\'.Ydb.Table.De" +
      "scribeTableOptionsResponse\022N\n\017StreamRead",
      "Table\022\033.Ydb.Table.ReadTableRequest\032\034.Ydb" +
      ".Table.ReadTableResponse0\001\022I\n\nBulkUpsert" +
      "\022\034.Ydb.Table.BulkUpsertRequest\032\035.Ydb.Tab" +
      "le.BulkUpsertResponse\022j\n\026StreamExecuteSc" +
      "anQuery\022\".Ydb.Table.ExecuteScanQueryRequ" +
      "est\032*.Ydb.Table.ExecuteScanQueryPartialR" +
      "esponse0\001B\031\n\027tech.ydb.table.v1b\006pr" +
      "oto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          tech.ydb.table.YdbTable.getDescriptor(),
        }, assigner);
    tech.ydb.table.YdbTable.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
