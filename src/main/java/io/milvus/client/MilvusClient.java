package io.milvus.client;

import io.milvus.param.R;
import io.milvus.param.RpcStatus;
import io.milvus.param.Task;
import io.milvus.param.alias.*;
import io.milvus.param.collection.*;
import io.milvus.param.dml.*;
import io.milvus.param.index.*;
import io.milvus.param.partition.*;
import io.milvus.param.response.*;


/**
 * An abstract interface that represents a Milvus client and defines the manipulation methods.
 * 
 */
public interface MilvusClient {

    /**
     * Creates a collection with a pre-defined schema.
     * 
     * @param requestParam A {@link CreateCollectionParam} object as the request parameter.
     * @return A {@linkplain CreateCollectionResponse} object indicating whether this operation succeeds.
     */
    R<CreateCollectionResponse> createCollection(CreateCollectionParam requestParam);

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
     * @return A {@linkplain ReleaseCollectionResponse} object indicating whether this operation succeeds.
     */
    R<ReleaseCollectionResponse> releaseCollection(ReleaseCollectionParam requestParam);

    /**
     * Drops a collection with all the entities it contains.
     * 
     * @param requestParam A {@link DropCollectionParam} object as the request parameter.
     * @return A {@linkplain DropCollectionResponse} object indicating whether this operation succeeds.
     */
    R<DropCollectionResponse> dropCollection(DropCollectionParam requestParam);

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
     * @return A {@linkplain HasCollectionResponse} indicates whether the specified collection exists.
     */
    R<HasCollectionResponse> hasCollection(HasCollectionParam requestParam);

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
     * @return A {@linkplain DropIndexResponse} object indicating whether this operation succeeds.
     */
    R<DropIndexResponse> dropIndex(DropIndexParam requestParam);

    /**
     * Lists the indexes built on the specified field.
     * 
     * @param requestParam A {@link ListIndexesParam} object as the request parameter.
     * @return A {@linkplain ListIndexesResponse} object containing the list of index names.
     */
    R<ListIndexesResponse> listIndexes(ListIndexesParam requestParam);

    /**
     * Shows whether the specified index exists in the collection.
     * 
     * @param requestParam A {@link HasIndexParam} object as the request parameter.
     * @return A {@linkplain HasIndexResponse} object indicating whether the index exists.
     */
    R<HasIndexResponse> hasIndex(HasIndexParam requestParam);

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
     * @return A {@linkplain CreatePartitionResponse} object indicating whether this operation succeeds.
     */
    R<CreatePartitionResponse> createPartition(CreatePartitionParam requestParam);

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
     * @return A {@linkplain ReleasePartitionResponse} object indicating whether this operation succeeds.
     */
    R<ReleasePartitionResponse> releasePartition(ReleasePartitionParam requestParam);

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
     * @return A {@linkplain DropPartitionResponse} object indicating whether this operation succeeds.
     */
    R<DropPartitionResponse> dropPartition(DropPartitionParam requestParam);

    /**
     * Shows whether a partition after the specified name exists.
     * 
     * @param requestParam A {@link HasPartitionParam} object as the request parameter.
     * @return A {@linkplain HasPartitionResponse} indicates whether the specified Partition exists.
     */
    R<HasPartitionResponse> hasPartition(HasPartitionParam requestParam);

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
     * @return A {@link CreateAliasResponse} object that offers methods to get information about ongoing tasks.
     * 
     */
    R<CreateAliasResponse> createAlias(CreateAliasParam requestParam);

    /**
     * Changes an alias for a collection.
     * 
     * @param requestParam An {@link AlterAliasParam} object as the request parameter.
     * @return A {@linkplain AlterAliasResponse} object indicating whether this operation succeeds.
     */
    R<AlterAliasResponse> alterAlias(AlterAliasParam requestParam);

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
     * @return A {@linkplain DropAliasResponse} object indicating whether this operation succeeds.
     */
    R<DropAliasResponse> dropAlias(DropAliasParam requestParam);

    /**
     * Describes a specified alias
     * 
     * @param requestParam A {@link DescribeAliasParam} object as the request parameter.
     * @return A {@linkplain DescribeAliasResponse} object containing the details of the specified alias.
     */
    R<DescribeAliasResponse> describeAlias(DescribeAliasParam requestParam);

    /**
     * Checks whether the specified alias exists.
     * 
     * @param requestParam A {@link HasAliasParam} object as the request parameter.
     * @return A {@linkplain HasAliasResponse} object indicating whether the specified alias exists.
     */
    R<HasAliasResponse> hasAlias(HasAliasParam requestParam);
}
