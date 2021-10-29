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

    // specialized index for auto-complete feature
    public static final String INDEX_SUGGESTER = "suggester";
    public static final String INDEX_TERMS_COMPLETION = "terms_autocomplete";

    public static final String INDEX_DENORMALIZED_ENTRY = "combined_entry";
    public static final String INDEX_DENORMALIZED_ASSEMBLY = "combined_assembly";
    public static final String INDEX_DENORMALIZED_POLYMER_ENTITY = "combined_polymer_entity";
    public static final String INDEX_DENORMALIZED_BRANCHED_ENTITY = "combined_branched_entity";
    public static final String INDEX_DENORMALIZED_NON_POLYMER_ENTITY = "combined_non_polymer_entity";
    public static final String INDEX_DENORMALIZED_POLYMER_ENTITY_INSTANCE = "combined_polymer_instance";
    public static final String INDEX_DENORMALIZED_MOL_DEFINITION = "combined_mol_definition";

    public static final String INDEX_UNRELEASED_ENTRY = "unreleased_entry";
    public static final String INDEX_UNSTRUCTURED_ENTRY = "unstructured_entry";

    public static final String INDEX_GROUP_POLYMER_ENTITY_UNIPROT_ACCESSION = "group_polymer_entity_uniprot_accession";
    public static final String INDEX_GROUP_POLYMER_ENTITY_SEQUENCE_IDENTITY = "group_polymer_entity_sequence_identity";
    public static final String INDEX_GROUP_ENTRY_DEPOSIT_GROUP = "group_entry_deposit_group";

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

    // this field indicates custom meta data associated with the index
    // https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-meta-field.html
    public static final String META = "_meta";
    public static final String META_SCHEMA_VERSION = "schema_version";
}
