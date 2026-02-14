package org.rcsb.common.constants;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentifierRegexTest {

    @Test
    public void matchesFourCharacterPdbId() {
        assertTrue(IdentifierRegex.PDB_ID_REGEX.matcher("1abc").matches());
    }

    @Test
    public void matchesFourCharacterPdbIdOptionallyWithValidSuffix() {
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher("1abc").matches());
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher("1abc" + IdentifierSeparator.ENTITY_SEPARATOR + "2").matches());
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher("1abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR + "1").matches());
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher("1abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A").matches());
    }
}
