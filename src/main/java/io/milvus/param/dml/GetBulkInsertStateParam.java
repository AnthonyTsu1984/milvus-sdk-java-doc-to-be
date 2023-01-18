package io.milvus.param.dml;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#getBulkInsertState(GetBulkInsertStateParam) getBulkInsertState()}.
 */
public class GetBulkInsertStateParam {
    private final int taskId;

    private GetBulkInsertStateParam(Builder builder) {
        this.taskId = builder.taskId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link GetBulkInsertStateParam} object class.
     */
    public static final class Builder {
        private int taskId;

        private Builder() {}

        /**
         * Shows the state of a bulk-insert task.
         * 
         * @param taskId A valid task ID is returned by {@link io.milvus.client.MilvusClient#listBulkInsertTasks(io.milvus.param.dml.ListBulkInsertParam) listBulkInsertTasks()}.
         * @return The builder object itself.
         */
        public Builder withTaskId(int taskId) {
            this.taskId = taskId;
            return this;
        }        

        /**
         * Verifies the input parameter and creates a {@link GetBulkInsertStateParam} object.
         * 
         * @return {@link GetBulkInsertStateParam}
         */
        public GetBulkInsertStateParam build() {
            return new GetBulkInsertStateParam(this);
        }
    }
}
