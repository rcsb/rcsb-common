package org.rcsb.common.constants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

class IdentifierRegexTest {

    @Test
    void matchesPdbId() {
        assertTrue(IdentifierRegex.PDB_ID_REGEX.matcher("1abc").matches());
    }

    @ParameterizedTest(name = "matches PDB ID with optional suffix: {0}")
    @MethodSource("validPdbIdsWithOptionalSuffixes")
    void matchesPdbIdOptionallyWithValidSuffix(String pdbId) {
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher(pdbId).matches());
    }

    private static Stream<String> validPdbIdsWithOptionalSuffixes() {
        return Stream.of(
                "1abc",
                "1abc" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "1abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR + "1",
                "1abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A"
        );
    }
}