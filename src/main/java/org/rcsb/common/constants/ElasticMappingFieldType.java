package org.rcsb.common.constants;

/**
 * Elasticsearch supports a number of different data types for the fields in a document.
 *
 * Created on 8/8/19.
 *
 * @author Yana Valasatava
 * @since 1.0.0
 */
public class ElasticMappingFieldType {

    private ElasticMappingFieldType() {}

    // Core data types.
    public static final String TEXT = "text";
    public static final String KEYWORD = "keyword";
    public static final String BOOLEAN = "boolean";
    public static final String INTEGER = "integer";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String DATE = "date";

    // Complex data types.
    public static final String OBJECT = "object";
    public static final String NESTED = "nested";

    public static final String COMPLETION = "completion";

    public static final String CONTEXTS = "contexts";

    // The join datatype is a special field that creates
    // parent/child relation within documents of the same
    // index.
    public static final String JOIN = "join";

    // An alias mapping defines an alternate name
    // for a field in the index.
    public static final String ALIAS = "alias";
}
