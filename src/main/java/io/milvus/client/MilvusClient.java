package io.milvus.client;

import io.milvus.param.R;
import io.milvus.param.RpcStatus;
import io.milvus.param.Task;
import io.milvus.param.ListAliasesResponse;
import io.milvus.param.GetCollectionStatisticsResponse;
import io.milvus.param.DescribeCollectionResponse;
import io.milvus.param.ListCollectionsResponse;
import io.milvus.param.DescribeIndexResponse;
import io.milvus.param.ListImportTaskResponse;
import io.milvus.param.GetImportStateResponse;
import io.milvus.param.FlushResponse;
import io.milvus.param.DescribePartitionResponse;
import io.milvus.param.ListPartitionsResponse;
import io.milvus.param.GetPartitionStatisticsResponse;
import io.milvus.param.alias.*;
import io.milvus.param.collection.*;
import io.milvus.param.dml.*;
import io.milvus.param.index.*;
import io.milvus.param.partition.*;


/**
 * An abstract interface that represents a Milvus client and defines the manipulation methods.
 * 
 */
public interface MilvusClient {

    /**
     * Creates a collection with a pre-defined schema.
     * 
     * @param requestParam A {@link CreateCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> createCollection(CreateCollectionParam requestParam);

    /**
     * Describes the detail of a collection.
     * 
     * @param requestParam A {@link DescribeCollectionParam} object as the request parameter.
     * @return A {@link DescribeCollectionResponse} object containing the statistical items.
     */
    R<DescribeCollectionResponse> describeCollection(DescribeCollectionParam requestParam);

    /**
     * Loads a collection to make it prepared for searches and queries.
     * 
     * @param requestParam A {@link LoadCollectionParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     */
    R<Task> loadCollection(LoadCollectionParam requestParam);

    /**
     * Releases the loaded collection from memory. All data in the released collection remains intact after this 
     * operation. You can load the collection back to memory again using
     *  {@link #loadCollection(LoadCollectionParam) loadCollection()}.
     * 
     * @param requestParam A {@link LoadCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> releaseCollection(ReleaseCollectionParam requestParam);

    /**
     * Drops a collection with all the entities it contains.
     * 
     * @param requestParam A {@link DropCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> dropCollection(DropCollectionParam requestParam);

    /**
     * Lists the statistical items of a collection.
     * 
     * @param requestParam A {@link GetCollectionStatisticsParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<GetCollectionStatisticsResponse> getCollectionStatistics(GetCollectionStatisticsParam requestParam);

    /**
     * Lists all collection names in the database.
     * 
     * @param requestParam A {@link ListCollectionsParam} object as the request parameter.
     * @return A {@link ListCollectionsResponse} object containing the names of all collections.
     */
    R<ListCollectionsResponse> listCollections(ListCollectionsParam requestParam);

    /**
     * Shows whether a collection after the specified name exists.
     * 
     * @param requestParam A {@link HasCollectionParam} object as the request parameter.
     * @return A boolean value indicates whether the specified collection exists.
     */
    R<Boolean> hasCollection(HasCollectionParam requestParam);

    /**
     * Creates an index on the specified field in a collection.
     * 
     * @param requestParam A {@link CreateIndexParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<Task> createIndex(CreateIndexParam requestParam);

    /**
     * Describes the index of a collection.
     * 
     * @param requestParam A {@link DescribeIndexParam} object as the request parameter.
     * @return A {@link DescribeIndexResponse} object contains the index details.
     */
    R<DescribeIndexResponse> describeIndex(DescribeIndexParam requestParam);

    /**
     * Drops the index of a collection.
     * 
     * @param requestParam A {@link DropIndexParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> dropIndex(DropIndexParam requestParam);

    /**
     * Inserts a data record into the specified collection as an entity.
     * 
     * @param requestParam A {@link InsertParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     */
    R<Task> insert(InsertParam requestParam);

    /**
     * Imports data from specified files in an S3-like block storage system.
     * 
     * @param requestParam A {@link BulkInsertParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     */
    R<Task> bulkInsert(BulkInsertParam requestParam);

    /**
     * Seals all entities in the specified collection. Any insertion after a flush operation results in generating 
     * new segments. Only sealed segments can be indexed.
     * 
     * @param requestParam A {@link FlushParam} object as the request parameter.
     * @return A {@link FlushResponse} object that offers methods to get information about the flush operation.
     */
    R<FlushResponse> flush(FlushParam requestParam);

    /**
     * Deletes specified entities from a collection.
     * 
     * @param requestParam A {@link DeleteParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     */
    R<Task> delete(DeleteParam requestParam);

    /**
     * Shows the state of a bulk-insert task.
     * 
     * @param requestParam A {@link GetBulkInsertStateParam} object as the request parameter.
     * @return A {@link GetImportStateResponse} object that contains information about the state of all ongoing bulk-insert tasks.
     */
    R<GetImportStateResponse> getBulkInsertState(GetBulkInsertStateParam requestParam);

    /**
     * Lists all ongoing bulk-insert tasks.
     * 
     * @param requestParam A {@link ListBulkInsertParam} object as the request parameter.
     * @return A {@link ListImportTaskResponse} object that contains details about all ongoing bulk-insert tasks.
     */
    R<ListImportTaskResponse> listBulkInsertTasks(ListBulkInsertParam requestParam);

    /**
     * Creates a partition with a pre-defined schema.
     * 
     * @param requestParam A {@link CreatePartitionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> createPartition(CreatePartitionParam requestParam);

    /**
     * Describes the detail of a partition.
     * 
     * @param requestParam A {@link DescribePartitionParam} object as the request parameter.
     * @return A {@link DescribePartitionResponse} object containing the statistical items.
     */
    R<DescribePartitionResponse> describePartition(DescribePartitionParam requestParam);

    /**
     * Loads a partition to make it prepared for searches and queries.
     * 
     * @param requestParam A {@link LoadPartitionParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     */
    R<Task> loadPartition(LoadPartitionParam requestParam);

    /**
     * Releases a partition of the loaded collection from memory. All data in the released partition remains intact after this 
     * operation. You can load the partition back to memory again using
     *  {@link #loadPartition(LoadPartitionParam) loadPartition()}.
     * 
     * @param requestParam A {@link LoadCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> releasePartition(ReleasePartitionParam requestParam);

    /**
     * Lists all partition names in the database.
     * 
     * @param requestParam A {@link ListPartitionsParam} object as the request parameter.
     * @return A {@link ListPartitionsResponse} object containing the names of all Partitions.
     */
    R<ListPartitionsResponse> listPartitions(ListPartitionsParam requestParam);

    /**
     * Drops a partition with all the entities it contains.
     * 
     * @param requestParam A {@link DropPartitionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> dropPartition(DropPartitionParam requestParam);

    /**
     * Shows whether a partition after the specified name exists.
     * 
     * @param requestParam A {@link HasPartitionParam} object as the request parameter.
     * @return A boolean value indicates whether the specified Partition exists.
     */
    R<Boolean> hasPartition(HasPartitionParam requestParam);

    /**
     * Lists the statistical items of a partition.
     * 
     * @param requestParam A {@link GetPartitionStatisticsParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<GetPartitionStatisticsResponse> getPartitionStatistics(GetPartitionStatisticsParam requestParam);

    /**
     * Creates an alias for a collection.
     * 
     * @param requestParam A {@link CreateAliasParam} object as the request parameter.
     * @return A {@link Task} object that offers methods to get information about ongoing tasks.
     * 
     */
    R<RpcStatus> createAlias(CreateAliasParam requestParam);

    /**
     * Changes an alias for a collection.
     * 
     * @param requestParam An {@link AlterAliasParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> alterAlias(AlterAliasParam requestParam);

    /**
     * Lists all aliases associated with the specified collection.
     * 
     * @param requestParam A {@link ListAliasesParam} object as the request parameter.
     * @return A {@link ListAliasesResponse} object containing all aliases assigned to the specified collection.
     */
    R<ListAliasesResponse> listAliases(ListAliasesParam requestParam);

    /**
     * Drops a specified alias.
     * 
     * @param requestParam A {@link DropAliasParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> dropAlias(DropAliasParam requestParam);
}
