package io.milvus.common.enums;

public enum IndexType {
    INVALID,
    FLAT,
    IVF_FLAT,
    IVF_SQ8,
    IVF_PQ,
    HNSW,
    ANNOY,
    RHNSW_FLAT,
    RHNSW_PQ,
    RHNSW_SQ,
    DISKANN,
    AUTOINDEX,
    //Only supported for binary vectors
    BIN_FLAT,
    BIN_IVF_FLAT,

    //Only for varchar type field
    TRIE   
}
