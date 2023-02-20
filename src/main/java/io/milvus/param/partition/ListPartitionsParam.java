package io.milvus.param.partition;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#listPartitions(ListPartitionsParam) listPartitions()}.
 */
public class ListPartitionsParam {
    private final String collectionName;
    private final double timeout;

    private ListPartitionsParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ListPartitionsParam} object class.
     */
    public static final class Builder {
        private String collectionName;
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
         * Verifies the input parameters and creates a new {@link ListPartitionsParam} instance.
         * 
         * @return {@link ListPartitionsParam}
         */
        public ListPartitionsParam build() {
            return new ListPartitionsParam(this);
        }
    }    
}
