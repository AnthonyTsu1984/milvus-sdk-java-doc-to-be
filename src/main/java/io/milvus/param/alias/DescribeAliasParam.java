package io.milvus.param.alias;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#describeAlias(DescribeAliasParam) describeAlias()}.
 */
public class DescribeAliasParam {
    private final String alias;
    private final double timeout;

    private DescribeAliasParam(DescribeAliasParam.Builder builder) {
        this.alias = builder.alias;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link DescribeAliasParam} class.
     */
    public static class Builder {
        private String alias;
        private double timeout;

        private Builder() {}

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
         * Verifies the input parameters and creates a new {@link DescribeAliasParam} instance.
         * 
         * @return {@link DescribeAliasParam}
         */
        public DescribeAliasParam build() {
            return new DescribeAliasParam(this);
        }        
    }
}
