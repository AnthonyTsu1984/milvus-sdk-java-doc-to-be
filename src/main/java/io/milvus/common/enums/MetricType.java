package io.milvus.common.enums;

public enum MetricType {
    INVALID,
    L2,
    IP,
    // Only supported for binary vectors
    HAMMING,
    JACCARD,
    TANIMOTO,
    SUBSTRUCTURE,
    SUPERSTRUCTURE,
    ;    
}
