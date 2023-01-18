package io.milvus.param.partition;

import java.util.List;

import io.milvus.param.enums.ConsistencyLevel;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#createPartition(CreatePartitionParam) createParatition()}.
 */
public class CreatePartitionParam {
    private final String collectionName;
    private final String partitionName;

    private CreatePartitionParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.partitionName = builder.partitionName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link CreatePartitionParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String partitionName;
        
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
         * Verifies the input parameters and creates a new {@link CreatePartitionParam} instance.
         * 
         * @return {@link CreatePartitionParam}
         */
        public CreatePartitionParam build() {
            return new CreatePartitionParam(this);
        }
    }
}
