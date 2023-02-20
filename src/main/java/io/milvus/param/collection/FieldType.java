package io.milvus.param.collection;

import java.util.Map;

import io.milvus.common.enums.DataType;
import io.milvus.param.Constant;

/**
 * The object class used to prepare parameters for the schema in {@link io.milvus.client.MilvusClient#createCollection(CreateCollectionParam) createCollection()}.
 */
public class FieldType {
    private final String name;
    private final boolean primaryKey;
    private final String description;
    private final DataType dataType;
    private final boolean autoID;
    private final Map<String, String> typeParams;

    private FieldType(FieldType.Builder builder) {
        this.name = builder.name;
        this.primaryKey = builder.primaryKey;
        this.description = builder.description;
        this.dataType = builder.dataType;
        this.autoID = builder.autoID;
        this.typeParams = builder.typeParams;
    } 
    
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link FieldType} object class.
     */
    public static class Builder {
        private String name;
        private boolean primaryKey;
        private String description;
        private DataType dataType;
        private boolean autoID;
        private Map<String, String> typeParams;

        private Builder() {}

        /**
         * Specifies the name of this field.
         * 
         * @param name A field name should be a string of 1 to 255 characters, starting with a letter or an 
         * underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Specifies whether this field is a primary key.
         * 
         * @param primaryKey A <code>true</code> value indicates that this field is the primary key. A collection 
         * has only one primary key.
         * @return The builder object itself.
         */
        public Builder withPrimaryKey(boolean primaryKey) {
            this.primaryKey = primaryKey;
            return this;
        }

        /**
         * Specifies the description of this field.
         * 
         * @param description A description should be a string of 1 to 65535 characters, starting with a letter
         *  or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Specifies the data type of this field.
         * 
         * @param dataType A valid data type should be from the {@link DataType} enumeration list.
         * @return The builder object itself.
         */
        public Builder withDataType(DataType dataType) {
            this.dataType = dataType;
            return this;
        }

        /**
         * @hidden
         * @param typeParams to be determined.
         * @return The builder object itself.
         */
        public Builder withTypeParams(Map<String, String> typeParams) {
            typeParams.forEach(this.typeParams::put);
            return this;
        }

        /**
         * Specifies the number of dimensions of the vector embeddings in this field. This applies only to <code>FLOAT_VECTOR</code> or <code>BINARY_VECTOR</code> fields.
         * 
         * @param dimension A number of dimension is a positive integer ranging from 1 to 32768.
         * @return The builder object itself.
         */
        public Builder withDimension(Integer dimension) {
            this.typeParams.put(Constant.VECTOR_DIM, dimension.toString());
            return this;
        }

        /**
         * Specifies the maximum length of a string in this field. This applies only to <code>VARCHAR</code> fields.
         * 
         * @param maxLength The maximum length of a field value is a positive integer ranging from 1 to 255.
         * @return The builder object itself.
         */
        public Builder withMaxLength(Integer maxLength) {
            this.typeParams.put(Constant.VARCHAR_MAX_LENGTH, maxLength.toString());
            return this;
        }

        /**
         * Specifies whether the primary key automatically increments as entities being inserted.
         * 
         * @param autoID A <code>true</code> value indicates that a primary key will be added and it automatically 
         * increments. In this case, you do not need to use {@link #withPrimaryKey(boolean)} manually specified a primary field.
         * @return The builder object itself
         */
        public Builder withAutoID(boolean autoID) {
            this.autoID = autoID;
            return this;
        }

        /**
         * Verifies the input parameters and creates a new {@link FieldType} instance.
         * 
         * @return {@link FieldType}
         */
        public FieldType build() {
            return new FieldType(this);
        }
    }

    public String toString() {
        return "FieldType{" +
                "name='" + name + '\'' +
                ", type='" + dataType.name() + '\'' +
                ", primaryKey=" + primaryKey +
                ", autoID=" + autoID +
                ", params=" + typeParams +
                '}';
    }
}
