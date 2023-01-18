package io.milvus.param.collection;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#listCollections(ListCollectionsParam) listCollections()}.
 */
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
