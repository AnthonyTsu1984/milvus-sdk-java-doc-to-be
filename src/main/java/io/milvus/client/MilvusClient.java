package io.milvus.client;

import io.milvus.param.R;
import io.milvus.param.RpcStatus;
import io.milvus.param.Task;
import io.milvus.param.ListAliasesResponse;
import io.milvus.param.GetCollectionStatisticsResponse;
import io.milvus.param.DescribeCollectionResponse;
import io.milvus.param.ListCollectionsResponse;
import io.milvus.param.DescribeIndexResponse;
import io.milvus.param.alias.*;
import io.milvus.param.collection.*;
import io.milvus.param.index.*;


public interface MilvusClient {

    /**
     * Creates a collection with a pre-defined schema.
     * 
     * @param requestParam A {@link CreateCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> CreateCollection(CreateCollectionParam requestParam);

    /**
     * Describes the detail of a collection.
     * 
     * @param requestParam A {@link DescribeCollectionParam} object as the request parameter.
     * @return A {@link DescribeCollectionResponse} object containing the statistical items.
     */
    R<DescribeCollectionResponse> DescribeCollection(DescribeCollectionParam requestParam);

    /**
     * Loads a collection to make it prepared for searches and queries.
     * 
     * @param requestParam A {@link LoadCollectionParam} object as the request parameter.
     * @return A {@link Task} object containing the details of this operation.
     */
    R<Task> LoadCollection(LoadCollectionParam requestParam);

    /**
     * Releases the loaded collection from memory. All data in the released collection remains intact after this 
     * operation. You can load the collection to memory again using
     *  {@link #LoadCollection(LoadCollectionParam) LoadCollection()}.
     * 
     * @param requestParam A {@link LoadCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> ReleaseCollection(ReleaseCollectionParam requestParam);

    /**
     * Drops a collection with all the entities it contains.
     * 
     * @param requestParam A {@link DropCollectionParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> DropCollection(DropCollectionParam requestParam);

    /**
     * Lists the statistical items of a collection.
     * 
     * @param requestParam A {@link GetCollectionStatisticsParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<GetCollectionStatisticsResponse> GetCollectionStatistics(GetCollectionStatisticsParam requestParam);

    /**
     * Lists all collection names in the database.
     * 
     * @param requestParam A {@link ListCollectionsParam} object as the request parameter.
     * @return A {@link ListCollectionsResponse} object containing the names of all collections.
     */
    R<ListCollectionsResponse> ListCollections(ListCollectionsParam requestParam);

    /**
     * Shows whether a collection after the specified name exists.
     * 
     * @param requestParam A {@link HasCollectionParam} object as the request parameter.
     * @return A boolean value indicates whether the specified collection exists.
     */
    R<Boolean> HasCollection(HasCollectionParam requestParam);

    /**
     * Creates an index on the specified field in a collection.
     * 
     * @param requestParam A {@link CreateIndexParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<Task> CreateIndex(CreateIndexParam requestParam);

    /**
     * Describes the index of a collection.
     * 
     * @param requestParam A {@link DescribeIndexParam} object as the request parameter.
     * @return A {@link DescribeIndexResponse} object contains the index details.
     */
    R<DescribeIndexResponse> DescribeIndex(DescribeIndexParam requestParam);

    /**
     * Drops the index of a collection.
     * 
     * @param requestParam A {@link DropIndexParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> DropIndex(DropIndexParam requestParam);

    /**
     * Inserts a data record into the specified collection as an entity.
     * 
     * @param requestParam A{@link IndexParam} object as the request parameter.
     * @return A {@link Task} object containing the details of this operation.
     */
    R<Task> Insert(InsertParam requestParam);

    /**
     * Creates an alias for a user
     * 
     * @param requestParam A {@link CreateAliasParam} object as the request parameter.
     * @return A {@link Task} object containing the details of this operation.
     * 
     */
    R<RpcStatus> CreateAlias(CreateAliasParam requestParam);

    /**
     * Changes an alias for a collection.
     * 
     * @param requestParam An {@link AlterAliasParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> AlterAlias(AlterAliasParam requestParam);

    /**
     * Lists all aliases associated with the specified collection.
     * 
     * @param requestParam A {@link ListAliasesParam} object as the request parameter.
     * @return A {@link ListAliasesResponse} object containing all aliases assigned to the specified collection.
     */
    R<ListAliasesResponse> ListAliases(ListAliasesParam requestParam);

    /**
     * Drops a specified alias.
     * 
     * @param requestParam A {@link DropAliasParam} object as the request parameter.
     * @return A {@linkplain RpcStatus} object indicating whether this operation succeeds.
     */
    R<RpcStatus> DropAlias(DropAliasParam requestParam);
}
