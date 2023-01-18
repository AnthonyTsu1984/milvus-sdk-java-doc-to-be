package io.milvus.param.collection;

import java.util.List;
import io.milvus.enums.ConsistencyLevel;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#CreateCollection(CreateCollectionParam) CreateCollection()}.
 */
public class CreateCollectionParam {
    private final String collectionName;
    private final int numShards;
    private final List<FieldType> schema;
    private final ConsistencyLevel consistencyLevel;

    private CreateCollectionParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.numShards = builder.numShards;
        this.schema = builder.schema;
        this.consistencyLevel = builder.consistencyLevel;
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
        private List<FieldType> schema;
        private ConsistencyLevel consistencyLevel; 
        
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
         * @param fields A list of {@link FieldType} objects.
         * @return The builder object itself.
         */
        public Builder withSchema(List<FieldType> fields) {
            this.schema.addAll(fields);
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
         * Adds a single field to the schema of the collection.
         * 
         * @param field A {@link FieldType} object.
         * @return The builder object itself.
         */
        public Builder addField(FieldType field) {
            this.schema.add(field);
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
