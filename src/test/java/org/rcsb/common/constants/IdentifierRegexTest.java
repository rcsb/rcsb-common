package org.rcsb.common.constants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

class IdentifierRegexTest {

    @ParameterizedTest(name = "matches PDB ID: {0}")
    @MethodSource("validPdbIds")
    void matchesPdbId(String pdbId) {
        assertTrue(IdentifierRegex.PDB_ID_REGEX.matcher(pdbId).matches());
    }

    private static Stream<String> validPdbIds() {
        return Stream.of("1abc", "1ABC", "1AbC", "1234");
    }

    @ParameterizedTest(name = "does not match PDB ID: {0}")
    @MethodSource("invalidPdbIds")
    void doesNotMatchInvalidPdbId(String pdbId) {
        assertFalse(IdentifierRegex.PDB_ID_REGEX.matcher(pdbId).matches());
    }

    private static Stream<String> invalidPdbIds() {
        return Stream.of("1ab_", "1ab", "1abcd", "abcd", "1ab-");
    }

    @Test
    void matchesExtendedPdbId() {
        assertTrue(IdentifierRegex.EXT_PDB_ID_REGEX.matcher("pdb_00001abc").matches());
    }

    @ParameterizedTest(name = "does not match extended PDB ID: {0}")
    @MethodSource("invalidExtendedPdbIds")
    void doesNotMatchInvalidExtendedPdbId(String extPdbId) {
        assertFalse(IdentifierRegex.EXT_PDB_ID_REGEX.matcher(extPdbId).matches());
    }

    private static Stream<String> invalidExtendedPdbIds() {
        return Stream.of(
                "PDB_00001ABC",
                "pdb_00001AbC",
                "pdb_00001ab",
                "pdb_00001abcd",
                "1abc",
                "pdb_00001ab-"
        );
    }

    @ParameterizedTest(name = "matches PDB ID with optional suffix: {0}")
    @MethodSource("validPdbIdsWithOptionalSuffixes")
    void matchesPdbIdOptionallyWithValidSuffix(String pdbId) {
        assertTrue(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher(pdbId).matches());
    }

    @ParameterizedTest(name = "matches extended PDB ID with optional suffix: {0}")
    @MethodSource("validExtPdbIdsWithOptionalSuffixes")
    void matchesExtPdbIdOptionallyWithValidSuffix(String extPdbId) {
        assertTrue(IdentifierRegex.EXT_PDB_ID_WITH_SUFFIX_REGEX.matcher(extPdbId).matches());
    }

    private static Stream<String> validExtPdbIdsWithOptionalSuffixes() {
        return Stream.of(
                "pdb_00001abc",
                "pdb_00001abc" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "pdb_00001abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR + "1",
                "pdb_00001abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A",
                "pdb_00001abc-1" + IdentifierSeparator.INTERFACE_SEPARATOR + "1",
                "pdb_00001abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "AA"
        );
    }

    @ParameterizedTest(name = "does not match extended PDB ID with suffix: {0}")
    @MethodSource("invalidExtPdbIdsWithSuffixes")
    void doesNotMatchInvalidExtPdbIdWithSuffix(String extPdbId) {
        assertFalse(IdentifierRegex.EXT_PDB_ID_WITH_SUFFIX_REGEX.matcher(extPdbId).matches());
    }

    private static Stream<String> invalidExtPdbIdsWithSuffixes() {
        return Stream.of(
                "PDB_00001ABC" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "pdb_00001ab" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "pdb_00001abc" + IdentifierSeparator.ENTITY_SEPARATOR,
                "1abc" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "pdb_00001abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A_1"
        );
    }

    @ParameterizedTest(name = "does not match PDB ID with suffix: {0}")
    @MethodSource("invalidPdbIdsWithSuffixes")
    void doesNotMatchInvalidPdbIdWithSuffix(String pdbId) {
        assertFalse(IdentifierRegex.PDB_ID_WITH_SUFFIX_REGEX.matcher(pdbId).matches());
    }

    private static Stream<String> invalidPdbIdsWithSuffixes() {
        return Stream.of(
                "1abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR + "1_1",
                "1abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A_",
                "1abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR
        );
    }

    private static Stream<String> validPdbIdsWithOptionalSuffixes() {
        return Stream.of(
                "1abc",
                "1abc" + IdentifierSeparator.ENTITY_SEPARATOR + "2",
                "1abc" + IdentifierSeparator.ASSEMBLY_SEPARATOR + "1",
                "1abc" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "A",
                "1abc-1" + IdentifierSeparator.INTERFACE_SEPARATOR + "1",
                "1ABC" + IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR + "AA"
        );
    }

    @ParameterizedTest(name = "isLegacyPdbId({0})")
    @MethodSource("validPdbIds")
    void isLegacyPdbIdTrueForLegacyIds(String id) {
        assertTrue(IdentifierRegex.isLegacyPdbId(id));
        assertTrue(IdentifierRegex.isAnyPdbId(id));
        assertFalse(IdentifierRegex.isExtPdbId(id));
    }

    @ParameterizedTest(name = "isExtPdbId({0})")
    @ValueSource(strings = {"pdb_00001abc", "pdb_12345678", "pdb_abcdefgh"})
    void isExtPdbIdTrueForExtendedIds(String id) {
        assertTrue(IdentifierRegex.isExtPdbId(id));
        assertTrue(IdentifierRegex.isAnyPdbId(id));
        assertFalse(IdentifierRegex.isLegacyPdbId(id));
    }

    @ParameterizedTest(name = "no flavour matches: {0}")
    @NullSource
    @ValueSource(strings = {
            "",
            "1ab",
            "1abcd",
            "PDB_00001ABC",
            "pdb_00001AbC",
            "pdb_00001ab",
            "1abc" + "_" + "2",
            "pdb_00001abc" + "_" + "2"
    })
    void noFlavourMatchesInvalidOrSuffixedIds(String id) {
        assertFalse(IdentifierRegex.isLegacyPdbId(id));
        assertFalse(IdentifierRegex.isExtPdbId(id));
        assertFalse(IdentifierRegex.isAnyPdbId(id));
    }
}
