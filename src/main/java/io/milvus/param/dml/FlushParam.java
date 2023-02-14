package io.milvus.param.dml;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#flush(FlushParam) flush()}.
 */
public class FlushParam {
    private final String collectionName;
    private final boolean asyncFlush;

    private FlushParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.asyncFlush = builder.asyncFlush;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link FlushParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private boolean asyncFlush;

        private Builder() {}

        /**
         * Specifies the name of the target collection.
         * 
         * @param collectionName A collection name should be a string of 1 to 255 characters, starting with a letter 
         * or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder class itself.
         */
        public Builder withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * Specifies whether this is an asynchronous operation.
         * 
         * @param asyncFlush A <code>true</code> value indicates that this is an asynchronous operation.
         * @return The builder class itself.
         */
        public Builder withAsyncFlush(boolean asyncFlush) {
            this.asyncFlush = asyncFlush;
            return this;
        }

        /**
         * Verifies the input parameters and creates a {@link FlushParam} object.
         * 
         * @return {@link FlushParam} 
         */
        public FlushParam build() {
            return new FlushParam(this);
        }
    }
}
