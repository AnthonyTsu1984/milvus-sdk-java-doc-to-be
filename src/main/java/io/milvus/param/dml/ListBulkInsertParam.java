package io.milvus.param.dml;

import java.net.http.HttpClient.Builder;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#listBulkInsertTasks(ListBulkInsertParam) listBulkInsertTasks()}.
 */
public class ListBulkInsertParam {
    private final String collectionName;
    private final int limit;

    private ListBulkInsertParam (Builder builder) {
        this.collectionName = builder.collectionName;
        this.limit = builder.limit;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link ListBulkInsertParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private int limit;   
        
        /**
         * Specifies the name of a collection so that only the tasks related to the collection are listed.
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
         * Specifies the maximum number of tasks to be listed.
         * 
         * @param limit A positive integer that is greater than the actual number of ongoing bulk-insert tasks results 
         * in listing only these tasks.
         * @return The builder object itself.
         */
        public Builder withLimit(int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Verifies the input parameters and creates a {@link ListBulkInsertParam} object.
         * 
         * @return {@linkplain ListBulkInsertParam}
         */
        public ListBulkInsertParam build() {
            return new ListBulkInsertParam(this);
        }
    }
}
