package io.milvus.param.dml;

import java.util.List;
/**
 * The object class used to prepare parameters for {@link io.milvus.client.MilvusClient#bulkInsert(BulkInsertParam) bulkInsert()}.
 */
public class BulkInsertParam {
    private final String collectionName;
    private final String partitionName;
    private final List<String> files;

    private BulkInsertParam(Builder builder) {
        this.collectionName = builder.collectionName;
        this.partitionName = builder.partitionName;
        this.files = builder.files;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The builder class for the {@link BulkInsertParam} object class.
     */
    public static final class Builder {
        private String collectionName;
        private String partitionName;
        private List<String> files; 
        
        private Builder () {}

        /**
         * Specifies the name of the target collection.
         * 
         * @param collectionName A collection name should be a string of 1 to 255 characters, starting with a letter
         *  or an underscore (_) and containing only numbers, letters, and underscores (_).
         * @return The builder object itself.
         */
        public Builder withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * Specifies the name of the target partition. If omitted, an arbitrary partition is selected.
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
         * Specifies a list of file URLs.
         * 
         * @param files A valid file should be a row-based JSON file stored in an S3-like block storage system. 
         * Specifically, you need to organize your data in a dictionary with rows as the key and all the data records 
         * in a list as the value. In the list, each record corresponds to a dictionary. The key of each dictionary 
         * member is a field name, the values are those of these fields. Note that the file size should be no greater 
         * than 1 GB.
         * <br><br>
         * For your reference, the following is an example row-based JSON structure containing two entities.
         * <pre>
         * {
         *    "rows": 
         *    [
         *        {
         *            "id": 0,
         *            "title": "The Reported Mortality Rate of Coronavirus Is Not Important", 
         *            "title_vector": [0.041732933, 0.013779674, -0.027564144, -0.013061441], 
         *            "link": "https://medium.com/swlh/the-reported-mortality-rate-of-coronavirus-is-not-important-369989c8d912",
         *            "reading_time": 13,
         *            "publication": " The Startup",
         *            "claps": 1100,
         *            "responses": 18    
         *        }, 
         *        {
         *            "id": 1,
         *            "title": "Dashboards in Python: 3 Advanced Examples for Dash Beginners and Everyone Else", 
         *            "title_vector": [0.0039737443, 0.003020432, -0.0006188639, 0.03913546], 
         *            "link": "https://medium.com/swlh/dashboards-in-python-3-advanced-examples-for-dash-beginners-and-everyone-else",
         *            "reading_time": 14,
         *            "publication": " The Startup",
         *            "claps": 726,
         *            "responses": 3  
         *        }
         *    ]
         * }
         * </pre>
         * @return The builder object itself.
         */
        public Builder withFiles(List<String> files) {
            this.files = files;
            return this;
        }

        /**
         * A helper method to add one more file to the file list.
         * 
         * @param file A valid file should be a row-based JSON file stored in an S3-like block storage system.  
         * @return The builder object itself.
         */
        public Builder addFile(String file) {
            this.files.add(file);
            return this;
        }

        /**
         * Verifies the input parameters and creates a {@link BulkInsertParam} object.
         * @return {@link BulkInsertParam}
         */
        public BulkInsertParam build() {
            return new BulkInsertParam(this);
        }
    }
}
