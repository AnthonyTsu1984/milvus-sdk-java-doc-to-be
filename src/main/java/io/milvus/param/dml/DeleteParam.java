package io.milvus.param.dml;

import java.util.List;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#delete(DeleteParam) delete()}.
 */
public class DeleteParam {
    private final String collectionName;
    private final String partitionName;
    private final String expr;
    private final List<Integer> primaryKeys;

    private DeleteParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.partitionName = builder.partitionName;
        this.expr = builder.expr;
        this.primaryKeys = builder.primaryKeys;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link DeleteParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String partitionName;
        private String expr;
        private List<Integer> primaryKeys; 

        private Builder() {}
       
        /**
         * Specifies the name of the collection in concern.
         * 
         * @param collectionName A collection name should be a string of 1 to 255 characters, starting with a 
         * letter or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * Specifies the name of a partition in concern. If omitted, all partitions are involved.
         * 
         * @param partitionName A partition name should be a string of 1 to 255 characters, starting with a 
         * letter or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withPartitionName(String partitionName) {
            this.partitionName = partitionName;
            return this;
        }

        /**
         * Specifies a boolean expression to match desired entities.
         * 
         * @param expr A valid boolean expression should comprise only the <code>in</code> operator with two operands.
         * @return The builder object itself.
         */
        public Builder withExpr(String expr) {
            this.expr = expr;
            return this;
        }

        /**
         * Specifies a list of entities in their primary keys.
         * 
         * @param primaryKeys Including a non-existent primary key in the list may result in failures.
         * @return The builder object itself.
         */
        public Builder withPrimaryKeys(List<Integer> primaryKeys) {
            this.primaryKeys = primaryKeys;
            return this;
        }

        /**
         * Verifies the input parameter and creates a {@link DeleteParam} object.
         * 
         * @return {@link DeleteParam}
         */
        public DeleteParam builder() {
            return new DeleteParam(this); 
        }
    }
}
