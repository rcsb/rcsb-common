package org.rcsb.common.constants;

/**
 * Created on 04/28/20.
 *
 * @author Yana Valasatava
 * @since 2.0.0
 */
public class MongoCollections {

	// non-public constructor is defined to make sure that
	// this collection of static members cannot be instantiated.
	private MongoCollections() {}

	// EXCHANGE DB COLLECTIONS
	public static final String COLL_PDBX_CORE_BIRD_CHEM_COMP = "bird_chem_comp_core";
	public static final String COLL_PDBX_CORE_DRUGBANK = "drugbank_core";
	public static final String COLL_PDBX_CORE_ENTRY = "pdbx_core_entry";

	public static final String COLL_PDBX_CORE_POLYMER_ENTITY = "pdbx_core_polymer_entity";
	public static final String COLL_PDBX_CORE_NONPOLYMER_ENTITY = "pdbx_core_nonpolymer_entity";
	public static final String COLL_PDBX_CORE_BRANCHED_ENTITY = "pdbx_core_branched_entity";

	public static final String COLL_PDBX_CORE_POLYMER_ENTITY_INSTANCE = "pdbx_core_polymer_entity_instance";
	public static final String COLL_PDBX_CORE_NONPOLYMER_ENTITY_INSTANCE = "pdbx_core_nonpolymer_entity_instance";
	public static final String COLL_PDBX_CORE_BRANCHED_ENTITY_INSTANCE = "pdbx_core_branched_entity_instance";

	public static final String COLL_PDBX_CORE_ASSEMBLY = "pdbx_core_assembly";

	public static final String COLL_PDBX_ENTITY_SEQUENCE_CLUSTERS = "entity_members";

	public static final String COLL_REPOSITORY_HOLDINGS_CURRENT = "repository_holdings_current_entry";
	public static final String COLL_REPOSITORY_HOLDINGS_REMOVED = "repository_holdings_removed_entry";
	public static final String COLL_REPOSITORY_HOLDINGS_UNRELEASED = "repository_holdings_unreleased_entry";
	public static final String COLL_REPOSITORY_HOLDINGS_COMBINED = "repository_holdings_combined_entry";

	public static final String COLL_TREE_NODE_LIST_GO = "tree_go_node_list";
	public static final String COLL_TREE_NODE_LIST_EC = "tree_ec_node_list";
	public static final String COLL_TREE_NODE_LIST_ATC = "tree_atc_node_list";
	public static final String COLL_TREE_NODE_LIST_CATH = "tree_cath_node_list";
	public static final String COLL_TREE_NODE_LIST_SCOP = "tree_scop_node_list";
	public static final String COLL_TREE_NODE_LIST_TAXONOMY = "tree_taxonomy_node_list";
	public static final String COLL_TREE_NODE_LIST_ECOD = "tree_ecod_node_list";
	public static final String COLL_TREE_NODE_LIST_SCOP2 = "tree_scop2_node_list";

	// DW CORE COLLECTIONS
	public static final String COLL_ASSEMBLY = "core_assembly";
	public static final String COLL_INTERFACE = "core_interface";
	public static final String COLL_ENTRY = "core_entry";

	public static final String COLL_POLYMER_ENTITY = "core_polymer_entity";
	public static final String COLL_NONPOLYMER_ENTITY = "core_nonpolymer_entity";
	public static final String COLL_BRANCHED_ENTITY = "core_branched_entity";

	public static final String COLL_POLYMER_ENTITY_INSTANCE = "core_polymer_entity_instance";
	public static final String COLL_NONPOLYMER_ENTITY_INSTANCE = "core_nonpolymer_entity_instance";
	public static final String COLL_BRANCHED_ENTITY_INSTANCE = "core_branched_entity_instance";

	public static final String COLL_CHEM_COMP = "core_chem_comp";

	public static final String COLL_UNIPROT = "core_uniprot";
	public static final String COLL_NCBI = "core_ncbi";
	public static final String COLL_DRUGBANK = "core_drugbank";
	public static final String COLL_PUBMED = "core_pubmed";
	public static final String COLL_PFAM = "core_pfam";

	// DW TREE COLLECTIONS
	public static final String COLL_TREE_SYMMETRY = "tree_symmetry";
	public static final String COLL_TREE_EC = "tree_ec";
	public static final String COLL_TREE_MEMBRANE = "tree_membrane";
	public static final String COLL_TREE_OPM = "tree_opm";
	public static final String COLL_TREE_GO = "tree_go";
	public static final String COLL_TREE_CATH = "tree_cath";
	public static final String COLL_TREE_SCOP = "tree_scop";
	public static final String COLL_TREE_TAXONOMY = "tree_taxonomy";
	public static final String COLL_TREE_GENOMIC = "tree_genomic";
	public static final String COLL_TREE_MESH = "tree_mesh";
	public static final String COLL_TREE_ATC = "tree_atc";
	public static final String COLL_TREE_ECOD = "tree_ecod";
	public static final String COLL_TREE_SCOP2 = "tree_scop2";

	// DW METADATA
	public static final String COLL_METADATA = "metadata";

	// ASSEMBLY level collections
	public static final String COLL_ASSEMBLY_SYMMETRY = "assembly_symmetry";

	// ENTITY level collections (RCSB derived properties)
	public static final String COLL_ENTITY_FEATURES_CALCULATED_HYDROPATHY = "entity_features_calculated_hydropathy";
	public static final String COLL_ENTITY_FEATURES_CALCULATED_DISORDER = "entity_features_calculated_disorder";

	public static final String COLL_SHAPE_DESCRIPTOR = "shape_descriptor";

	//Annotations collection
	public static final String COLL_ANNOTATIONS_UNIPROT = "annotations_uniprot";
	public static final String COLL_ANNOTATIONS_POLYMER_ENTITY = "annotations_polymer_entity";
	public static final String COLL_ANNOTATIONS_POLYMER_ENTITY_INSTANCE = "annotations_polymer_entity_instance";
}
