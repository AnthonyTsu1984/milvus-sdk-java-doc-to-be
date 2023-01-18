package io.milvus.param.index;

import java.util.Dictionary;

public class CreateIndexParam {
    private final String collectionName;
    private final String fieldName;
    private final String indexName;
    private final String indexType;
    private final String metricType;
    private final Dictionary extraParam;
    private final Boolean syncMode;
    private final int syncWaitingInterval;
    private final int syncWaitingTimeout;

    private CreateIndexParam (Builder builder) {
        this.collectionName = builder.collectionName;
        this.fieldName = builder.fieldName;
        this.indexName = builder.indexName;
        this.indexType = builder.indexType;
        this.metricType = builder.metricType;
        this.extraParam = builder.extraParam;
        this.syncMode = builder.syncMode;
        this.syncWaitingInterval = builder.syncWaitingInterval;
        this.syncWaitingTimeout = builder.syncWaitingTimeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link CreateIndexParam} object class.
     */
    public static class Builder {
        private String collectionName;
        private String fieldName;
        private String indexName;
        private String indexType;
        private String metricType;
        private Dictionary extraParam;
        private Boolean syncMode;
        private int syncWaitingInterval;
        private int syncWaitingTimeout;  
        
        private Builder() {}

        /**
         * Specifies a collection desired for the operation.
         * 
         * @param collectionName A collection name should be a string of 1 to 255 characters, starting with 
         * a letter or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * Specifies the name of the field on which the index is to be created.
         * 
         * @param fieldName A field name should be a string of 1 to 255 characters, starting with 
         * a letter or an underscore (_) and containing only numbers, letters, and underscores (_). 
         * @return The builder object itself.
         */
        public Builder withFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        /**
         * Specifies the name of the index for further reference.
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
         * Specifies a valid indexing algorithm used to accelerate vector searches.
         * 
         * @param indexType A valid index type from the reference documents below.
         * @see <a href="https://milvus.io/docs/index.md">In-memory Index</a> and
         *  <a href="https://milvus.io/docs/disk_index.md">On-disk Index</a>
         * @return The builder object itself.
         */
        public Builder withIndexType(String indexType) {
            this.indexType = indexName;
            return this;
        }

        /**
         * Specifies a valid type of metrics used to measure vector similarities. 
         * 
         * @param metricType A valid metric type from the reference documents below.
         * @see <a href="https://milvus.io/docs/metric.md">Similarity Metrics</a>
         * @return The builder object itself.
         */
        public Builder withMetricType(String metricType) {
            this.metricType = metricType;
            return this;
        }

        /**
         * Specifies other applicable index-building parameters. 
         * 
         * @param extraParam These parameters vary with index types. For details, see the reference documents below.
         * @see <a href="https://milvus.io/docs/index.md">In-memory Index</a> and
         *  <a href="https://milvus.io/docs/disk_index.md">On-disk Index</a>
         * @return The builder object itself.
         */
        public Builder withExtraParam(Dictionary extraParam) {
            this.extraParam = extraParam;
            return this;
        }

        /**
         * Specifies whether this operation is synchronous.
         * 
         * @param syncMode A <code>true</code> value indicates that this operation is synchronous.
         * @return The builder object itself.
         */
        public Builder withSyncMode(Boolean syncMode) {
            this.syncMode = syncMode;
            return this;
        }

        /**
         * Specifies an interval at which the client checks whether the index-creating process completes.
         * 
         * @param syncWaitingInterval An interval is a positive integer. A smaller value indicates a more intensive 
         * checking frequency. 
         * @return The builder object itself.
         */
        public Builder withSyncWaitingInterval(int syncWaitingInterval) {
            this.syncWaitingInterval = syncWaitingInterval;
            return this;
        }

        /**
         * Specifies a timeout duration after which the client stops checking the index-creating process no matter 
         * whether the process completes.
         * 
         * @param syncWaitingTimeout A timeout duration is a positive integer.
         * @return The builder object itself.
         */
        public Builder withSyncWaitingTimeout(int syncWaitingTimeout) {
            this.syncWaitingTimeout = syncWaitingTimeout;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link CreateIndexParam} instance.
         * 
         * @return {@link CreateIndexParam}
         */
        public CreateIndexParam build() {
            return new CreateIndexParam(this);
        }
    }
}
