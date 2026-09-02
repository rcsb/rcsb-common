package org.rcsb.common.constants;

import java.util.regex.Pattern;

public class IdentifierRegex {

    private static final String ALPHANUM_VALUE = "[a-zA-Z0-9]";

    private static final String PDB_ID_REGEX_VALUE = "\\d" + ALPHANUM_VALUE + "{3}";

    private static final String EXT_PDB_ID_REGEX_VALUE = "pdb_[a-z0-9]{8}";

    private static final String SUFFIX_REGEX_VALUE = String.format(
            "(?:%1$s%5$s+(?:%2$s%5$s+)?|%3$s%5$s+|%4$s%5$s+)?",
            Pattern.quote(IdentifierSeparator.ASSEMBLY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.INTERFACE_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR),
            ALPHANUM_VALUE);

    public static final Pattern PDB_ID_REGEX = Pattern.compile("^" + PDB_ID_REGEX_VALUE + "$");

    public static final Pattern EXT_PDB_ID_REGEX = Pattern.compile("^" + EXT_PDB_ID_REGEX_VALUE + "$");

    public static final Pattern PDB_ID_WITH_SUFFIX_REGEX =
            Pattern.compile("^" + PDB_ID_REGEX_VALUE + SUFFIX_REGEX_VALUE + "$");

    public static final Pattern EXT_PDB_ID_WITH_SUFFIX_REGEX =
            Pattern.compile("^" + EXT_PDB_ID_REGEX_VALUE + SUFFIX_REGEX_VALUE + "$");
}
