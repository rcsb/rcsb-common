package org.rcsb.common.constants;

import java.util.regex.Pattern;

public class IdentifierRegex {

    private static final String PDB_ID_REGEX_VALUE = "^(?:\\d\\w{3}|pdb_\\d{5}\\w{3})$";

    public static final Pattern PDB_ID_REGEX = Pattern.compile(PDB_ID_REGEX_VALUE, Pattern.CASE_INSENSITIVE);

    private static final String PDB_ID_WITH_SUFFIX_REGEX_VALUE = String.format(
            "^(?:\\d\\w{3}|pdb_\\d{5}\\w{3})(?:%s\\w+(?:%s\\w+)?|%s\\w+|%s\\w+)?$",
            Pattern.quote(IdentifierSeparator.ASSEMBLY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.INTERFACE_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR));

    public static final Pattern PDB_ID_WITH_SUFFIX_REGEX = Pattern.compile(PDB_ID_WITH_SUFFIX_REGEX_VALUE, Pattern.CASE_INSENSITIVE);
}
