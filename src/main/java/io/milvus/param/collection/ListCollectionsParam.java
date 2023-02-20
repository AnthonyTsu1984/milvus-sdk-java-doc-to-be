package io.milvus.param.collection;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#listCollections(ListCollectionsParam) listCollections()}.
 */
public class ListCollectionsParam {
    private final double timeout;

    private ListCollectionsParam(Builder builder) {
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ListCollectionsParam} object class.
     */
    public static final class Builder {
        private double timeout;

        private Builder() {}

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
         * Verifies the input parameters and creates a new {@link ListCollectionsParam} instance.
         * 
         * @return {@link ListCollectionsParam}
         */
        public ListCollectionsParam build() {
            return new ListCollectionsParam(this);
        }
    }    
}
