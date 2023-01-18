package io.milvus.param.index;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#dropIndex(DropIndexParam) dropIndex()}.
 * 
 */
public class DropIndexParam {
    private final String collectionName;
    private final String indexName;

    private DropIndexParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.indexName = builder.indexName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link DropIndexParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String indexName;

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
         * Specifies the name of the index to drop.
         * 
         * @param indexName An index name should be a string of 1 to 255 characters, starting with 
         * a letter or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withIndexName(String indexName) {
            this.indexName = indexName;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link DropIndexParam} instance.
         * 
         * @return {@link DropIndexParam}
         */
        public DropIndexParam build() {
            return new DropIndexParam(this);
        }
    }    
}
