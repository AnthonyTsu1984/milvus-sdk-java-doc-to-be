package io.milvus.param.index;

public class ListIndexesParam {
    private final String collectionName;
    private final String fieldName;
    private final double timeout;

    private ListIndexesParam(ListIndexesParam.Builder builder) {
        this.collectionName = builder.collectionName;
        this.fieldName = builder.fieldName;
        this.timeout = builder.timeout;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String collectionName;
        private String fieldName;
        private double timeout;

        private Builder () {}

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
         * Specifies the name of a field. 
         * 
         * @param fieldName A field name should be a string of 1 to 255 characters, starting with a letter 
         * or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withFieldName(String fieldName) {
            this.fieldName = fieldName;
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
         * Verified the input and creates a new {@link ListIndexesParam} object.
         * 
         * @return {@link ListIndexesParam} 
         */
        public ListIndexesParam build() {
            return new ListIndexesParam(this);
        }


    }
}
