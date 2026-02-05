package org.rcsb.common.constants;

import java.util.Map;

/**
 * A name of an Elasticsearch index used by the RCSB PDB.
 * Each enum constant represents a specific Elasticsearch index type,
 * with associated index names strings.
 */
public enum ElasticsearchIndexName {

    /** Represents the index for suggester component models. */
    suggester("suggester_pdb", "suggester_csm", "suggester_all"),

    /** Represents the index for autocomplete component models. */
    autocomplete("terms_autocomplete_pdb", "terms_autocomplete_csm", "terms_autocomplete_all"),

    /** Represents the index for unstructured entry component models. */
    unstructured_entry("unstructured_entry_pdb", "unstructured_entry_csm", "unstructured_entry_all"),

    /** Represents the index for combined entry component models. */
    denormalized_entry("combined_entry_pdb", "combined_entry_csm", "combined_entry_all"),

    /** Represents the index for combined assembly component models. */
    denormalized_assembly("combined_assembly_pdb", "combined_assembly_csm", "combined_assembly_all"),

    /** Represents the index for combined polymer entity component models. */
    denormalized_polymer_entity("combined_polymer_entity_pdb", "combined_polymer_entity_csm", "combined_polymer_entity_all"),

    /** Represents the index for combined branched entity models. */
    denormalized_branched_entity("combined_branched_entity_pdb", "combined_branched_entity_csm", "combined_branched_entity_all"),

    /** Represents the index for combined non-polymer entity models. */
    denormalized_non_polymer_entity("combined_non_polymer_entity_pdb", "combined_non_polymer_entity_csm", "combined_non_polymer_entity_all"),

    /** Represents the index for combined molecular definition models. */
    denormalized_mol_definition("combined_mol_definition_pdb", "combined_mol_definition_csm", "combined_mol_definition_all"),

    /** Represents the index for unreleased entries. */
    unreleased_entry("unreleased_entry_pdb", "unreleased_entry_csm", "unreleased_entry_all");

    private final Map<LoadPdbCsmType, String> indexNamesByLoadType;

    ElasticsearchIndexName(String namePdb, String nameCsm, String nameAll) {
        indexNamesByLoadType = Map.of(LoadPdbCsmType.PDB, namePdb, LoadPdbCsmType.CSM, nameCsm, LoadPdbCsmType.ALL, nameAll);
    }

    public String getIndexName(LoadPdbCsmType loadType) {
        return indexNamesByLoadType.get(loadType);
    }
}
