package io.milvus.param.partition;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#releasePartition(ReleasePartitionParam) releasePartition()}.
 */
public class ReleasePartitionParam {
    private final String collectionName;
    private final String partitionName;
    private final double timeout;

    private ReleasePartitionParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.partitionName = builder.partitionName;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ReleasePartitionParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String partitionName;
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
         * Specifies the name of a partition.
         * 
         * @param partitionName A partition name should be a string of 1 to 255 characters, starting with a letter 
         * or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withPartitionName(String partitionName) {
            this.partitionName = partitionName;
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
         * Verifies the input parameters and creates a new {@link ReleasePartitionParam} instance.
         * 
         * @return {@link ReleasePartitionParam}
         */
        public ReleasePartitionParam build() {
            return new ReleasePartitionParam(this);
        }
    }    
}
