package org.rcsb.common.constants;

/**
 * A name of an Elasticsearch index used by the RCSB PDB.
 * Each enum constant represents a specific Elasticsearch index,
 * defined by its associated index name string.
 */
public enum ElasticsearchIndexName {

    /** Represents the index for suggester component models. */
    suggester("suggester_comp_model"),

    /** Represents the experimental-only index for suggesters. */
    suggester_experimental_only("suggester"),

    /** Represents the index for autocomplete component models. */
    autocomplete("terms_autocomplete_comp_model"),

    /** Represents the experimental-only index for autocompletes. */
    autocomplete_experimental_only("terms_autocomplete"),

    /** Represents the index for unstructured entry component models. */
    unstructured_entry("unstructured_entry_comp_model"),

    /** Represents the index for combined entry component models. */
    denormalized_entry("combined_entry_comp_model"),

    /** Represents the index for combined assembly component models. */
    denormalized_assembly("combined_assembly_comp_model"),

    /** Represents the index for combined polymer entity component models. */
    denormalized_polymer_entity("combined_polymer_entity_comp_model"),

    /** Represents the index for combined branched entity models. */
    denormalized_branched_entity("combined_branched_entity"),

    /** Represents the index for combined non-polymer entity models. */
    denormalized_non_polymer_entity("combined_non_polymer_entity"),

    /** Represents the index for combined molecular definition models. */
    denormalized_mol_definition("combined_mol_definition"),

    /** Represents the index for unreleased entries. */
    unreleased_entry("unreleased_entry"),

    /** Represents the index for combined groups models. */
    denormalized_groups("combined_groups");

    private final String name;

    ElasticsearchIndexName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the Elasticsearch index associated with the enum constant.
     */
    @Override
    public String toString() {
        return name;
    }

}
