package io.milvus.param.dml;

import java.util.List;

/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#insert(InsertParam) insert()}.
 */
public class InsertParam {
    private final String collectionName;
    private final String partitionName;
    private final List<InsertParam.Field> fields;

    private InsertParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.partitionName = builder.partitionName;
        this.fields = builder.fields;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link InsertParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String partitionName;
        private List<InsertParam.Field> fields;

        private Builder() {}

        /**
         * Specifies the name of the target collection.
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
         * Specifies the name of the target partition. If omitted, an arbitrary partition is selected.
         * 
         * @param partitionName A partition name should be a string of 1 to 255 characters, starting with a letter 
         * or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withPartitionName(String partitionName) {
            this.partitionName = partitionName;
            return this;
        }

        /**
         * Specifies the fields to be inserted.
         * 
         * @param fields A set of fields should be organized using the {@link InsertParam.Field} object class.
         * @return The builder object itself.
         */
        public Builder withFields(List<InsertParam.Field> fields) {
            this.fields = fields;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link InsertParam} instance.
         * 
         * @return {@link InsertParam}
         */
        public InsertParam build() {
            return new InsertParam(this);
        }
    }

    /**
     * Creates a {@linkplain Field} object.
     */
    public static class Field {
        private final String name;
        private final List<?> values;

        public Field(String name, List<?> values) {
            this.name = name;
            this.values = values;
        }

        /**
         * Return the name of the field.
         *
         * @return <code>String</code>
         */
        public String getName() {
            return name;
        }

        /**
         * Return the data of the field, in column-base.
         *
         * @return <code>List</code>
         */
        public List<?> getValues() {
            return values;
        }

        /**
         * Constructs a <code>String</code> by {@link InsertParam.Field} instance.
         *
         * @return <code>String</code>
         */
        @Override
        public String toString() {
            return "Field{" +
                    "fieldName='" + name + '\'' +
                    ", row_count=" + values.size() +
                    '}';
        }
    }
}
