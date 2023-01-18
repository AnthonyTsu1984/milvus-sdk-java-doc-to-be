package io.milvus.param.collection;

public class ListCollectionsParam {

    private ListCollectionsParam(Builder builder) {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ListCollectionsParam} object class.
     */
    public static final class Builder {

        private Builder() {}

        /**
         * Creates a new {@link ListCollectionsParam} instance.
         * 
         * @return {@link ListCollectionsParam}
         */
        public ListCollectionsParam build() {
            return new ListCollectionsParam(this);
        }
    }    
}
