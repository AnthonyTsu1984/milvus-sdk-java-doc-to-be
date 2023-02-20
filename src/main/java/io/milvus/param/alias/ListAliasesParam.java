package io.milvus.param.alias;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#listAliases(ListAliasesParam) listAliases()}.
 */
public class ListAliasesParam {
    private final String collectionName;
    private final double timeout;

    private ListAliasesParam(ListAliasesParam.Builder builder) {
        this.collectionName = builder.collectionName;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ListAliasesParam} class.
     */
    public static class Builder {
        private String collectionName;
        private double timeout;

        private Builder () {}

        /**
         * Specifies the name of a target collection. 
         * 
         * @param collectionName A collection name should be
         *  a string of 1 to 255 characters, starting with a letter or an underscore (_) and containing only numbers, 
         * letters, and underscores (_).
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
         * Verifies the input parameters and creates a new {@link ListAliasesParam} instance.
         * 
         * @return {@link ListAliasesParam}
         */
        public ListAliasesParam build() {
            return new ListAliasesParam(this);
        }
    }    
}
