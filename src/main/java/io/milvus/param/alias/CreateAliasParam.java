package io.milvus.param.alias;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#CreateAlias(CreateAliasParam) CreateAlias()}.
 */
public class CreateAliasParam {
    private final String collectionName;
    private final String alias;

    private CreateAliasParam(CreateAliasParam.Builder builder) {
        this.collectionName = builder.collectionName;
        this.alias = builder.alias;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link CreateAliasParam} class.
     */
    public static class Builder {
        private String collectionName;
        private String alias;

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
         * Specifies an alias desired for the collection.
         * 
         * @param alias A collection alias should be a string of 1 to 255 characters, starting
         *  with a letter or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withAlias(String alias) {
            this.alias = alias;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link CreateAliasParam} instance.
         * 
         * @return {@link CreateAliasParam}
         */
        public CreateAliasParam build() {
            return new CreateAliasParam(this);
        }
    }
}
