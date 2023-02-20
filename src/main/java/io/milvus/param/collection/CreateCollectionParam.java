package io.milvus.param.collection;

import java.util.List;

import io.milvus.common.enums.ConsistencyLevel;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#createCollection(CreateCollectionParam) createCollection()}.
 */
public class CreateCollectionParam {
    private final String collectionName;
    private final CollectionSchema schema;
    private final int numShards;
    private final ConsistencyLevel consistencyLevel;
    private final double timeout;

    private CreateCollectionParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.numShards = builder.numShards;
        this.schema = builder.schema;
        this.consistencyLevel = builder.consistencyLevel;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link CreateCollectionParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private int numShards;
        private CollectionSchema schema;
        private ConsistencyLevel consistencyLevel; 
        private double timeout;
        
        private Builder() {}

        /**
         * Specifies the name of a collection. 
         * 
         * @param collectionName A collection name should be a string of 1 to 255 characters, starting with a letter 
         * or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * Specifies the number of shards in the collection.
         * 
         * @param numShards The number of shards should be no greater than 256. The value defaults to 2, indicating
         *  that two shards are to be created.
         * @return The builder object itself.
         */
        public Builder withNumShards(int numShards) {
            this.numShards = numShards;
            return this;
        }

        /**
         * Specifies the schema of the collection.
         * 
         * @param schema A {@link CollectionSchema} object defines the schema of the collection in detail.
         * @return The builder object itself.
         */
        public Builder withSchema(CollectionSchema schema) {
            this.schema = schema;
            return this;
        }

        /**
         * Specifies the consistency level of the collection.
         * 
         * @param consistencyLevel Consistency in a distributed database specifically refers to the property that 
         * ensures every node or replica has the same view of data when writing or reading data at a given time. 
         * @see <a href="https://milvus.io/docs/consistency.md#Consistency-levels">Consistency Level</a>
         * @return The builder object itself.
         */
        public Builder withConsistencyLevel(ConsistencyLevel consistencyLevel) {
            this.consistencyLevel = consistencyLevel;
            return this;
        }

        /**
         * (Optional) Specifies the timeout duration of this operation. If not called, no such limit applies.
         * 
         * @param timeout A double indicating the timeout duration in seconds.
         * @return The builder object itself.
         */
        public Builder withTimeout(double timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link CreateCollectionParam} instance.
         * 
         * @return {@link CreateCollectionParam}
         */
        public CreateCollectionParam build() {
            return new CreateCollectionParam(this);
        }
    }
}
