package io.milvus.param.collection;

public class LoadCollectionParam {
    private final String collectionName;
    private final Boolean aync;
    private final int loadWaitingInterval;
    private final int loadWaitingTimeout;
    private final int numReplicas;

    private LoadCollectionParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.async = builder.async;
        this.loadWaitingInterval = builder.loadWaitingInterval;
        this.loadWaitingTimeout = builder.loadWaitingTimeout;
        this.numReplicas = builder.numReplicas;

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link LoadCollectionParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private Boolean aync;
        private int loadWaitingInterval;
        private int loadWaitingTimeout;
        private int numReplicas;

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
         * Specifies whether Milvus loads the collection asynchronously. 
         * 
         * @param async A <code>true</code> value indicates that Milvus loads the collection asynchronously. 
         * @return The builder object itself.
         */
        public Builder withAsyncLoad(Boolean async) {
            this.async = async;
            return this;
        }

        /**
         * Specifies an interval at which the client checks whether the loading process completes.
         * 
         * @param loadWaitingInterval An interval is a positive integer. A smaller value indicates a more intensive 
         * checking frequency. 
         * @return The builder object itself.
         */
        public Builder withLoadWaitingInterval(int loadWaitingInterval) {
            this.loadWaitingInterval = loadWaitingInterval;
            return this;
        }

        /**
         * Specifies a timeout duration after which the client stops checking the loading process no matter 
         * whether the process completes.
         * 
         * @param loadWaitingTimeout A timeout duration is a positive integer.
         * @return The builder object itself.
         */
        public Builder withLoadWaitingTimeout(int loadWaitingTimeout) {
            this.loadWaitingTimeout = loadWaitingTimeout;
            return this;
        }

        /**
         * Specifies the number of replicas to load.
         * 
         * @param numReplicas The number of replicas is an integer that defaults to 1, indicating that only one
         *  replica is loaded.
         * @return The builder object itself.
         */
        public Builder withNumReplicas(int numReplicas) {
            this.numReplicas = numReplicas;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link LoadCollectionParam} instance.
         * 
         * @return {@link LoadCollectionParam}
         */
        public LoadCollectionParam build() {
            return new LoadCollectionParam(this);
        }
    }    
}
