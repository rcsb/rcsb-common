package org.rcsb.common.constants;

import java.util.regex.Pattern;

public class IdentifierRegex {

    private static final String PDB_ID_WITH_OPTIONAL_SUFFIX_REGEX_VALUE = String.format(
            "^\\d\\w\\w\\w(?:%s\\w+|%s\\w+|%s\\w+)?$",
            Pattern.quote(IdentifierSeparator.ENTITY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ASSEMBLY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR));

    public static final Pattern PDB_ID_REGEX = Pattern.compile(PDB_ID_WITH_OPTIONAL_SUFFIX_REGEX_VALUE);
}
