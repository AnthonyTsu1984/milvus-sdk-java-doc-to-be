package io.milvus.param.collection;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#describeCollection(DescribeCollectionParam) describeCollection()}.
 */
public class DescribeCollectionParam {
    private final String collectionName;

    private DescribeCollectionParam(Builder builder) {
        this.collectionName = builder.collectionName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link DescribeCollectionParam} object class.
     */
    public static final class Builder {
        private String collectionName;

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
         * Verifies the input parameters and creates a new {@link DescribeCollectionParam} instance.
         * 
         * @return {@link DescribeCollectionParam}
         */
        public DescribeCollectionParam build() {
            return new DescribeCollectionParam(this);
        }
    }
}
