package io.milvus.param.alias;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#dropAlias(DropAliasParam) dropAlias()}.
 */
public class DropAliasParam {
    private final String alias;

    private DropAliasParam(DropAliasParam.Builder builder) {
        this.alias = builder.alias;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link DropAliasParam} class.
     */
    public static class Builder {
        private String alias;

        private Builder () {}

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
         * Verifies the input parameters and creates a new {@link DropAliasParam} instance.
         * 
         * @return {@link CreateAliasParam}
         */
        public DropAliasParam build() {
            return new DropAliasParam(this);
        }
    }     
}
