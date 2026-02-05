package org.rcsb.common.constants;

/**
 * Created on 04/28/20.
 *
 * @author Yana Valasatava
 * @since 2.0.0
 */
public class ElasticsearchConstants {

    // non-public constructor is defined to make sure that
    // this collection of static members cannot be instantiated.
    private ElasticsearchConstants() {}

    // 'keyword' is an arbitrary word chosen to namespace fields indexed for exact match searches,
    // when input is not analyzed
    public static final String KEYWORD_SUFFIX = "keyword";

    // 'normalized' is an arbitrary word chosen to namespace fields indexed for exact match searches,
    // when a custom normalizer ("lowercase", "asciifolding") is applied to the input
    public static final String NORMALIZED_SUFFIX = "normalized";

    // 'suggest' is an arbitrary word chosen to namespace fields indexed to build autocomplete
    // functionality
    public static final String COMPLETION_SUFFIX = "completion";

    // 'text' is an arbitrary word chosen to namespace fields indexed for full-text searches
    public static final String TEXT_SUFFIX = "text";

    // this field contains an array of all text fields in unstructured manner
    public static final String COPY_TO_FIELD = "copy_all";

    // this field indicates custom metadata associated with the index
    // https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-meta-field.html
    public static final String META = "_meta";
    public static final String META_SCHEMA_VERSION = "schema_version";
}
