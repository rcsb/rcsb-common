package org.rcsb.common.constants;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Regular expressions for PDB identifiers, plus convenience methods to test strings against them.
 *
 * <p>Two identifier flavours are supported: the legacy 4-character id (e.g. {@code 1abc}) and the
 * extended id (e.g. {@code pdb_00001abc}). Both may optionally carry a suffix built from the
 * separators in {@link IdentifierSeparator}.
 */
public class IdentifierRegex {

    private static final String ALPHANUM_VALUE = "[a-zA-Z0-9]";

    private static final String PDB_ID_REGEX_VALUE = "\\d" + ALPHANUM_VALUE + "{3}";

    private static final String EXT_PDB_ID_REGEX_VALUE = "pdb_[a-z0-9]{8}";

    // this prefix supports transition periods when both legacy and extended IDs must be handled.
    private static final String EXTENDED_PREFIX = "pdb_0000";

    private static final String SUFFIX_REGEX_VALUE = String.format(
            "(?:%1$s%5$s+(?:%2$s%5$s+)?|%3$s%5$s+|%4$s%5$s+)?",
            Pattern.quote(IdentifierSeparator.ASSEMBLY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.INTERFACE_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_SEPARATOR),
            Pattern.quote(IdentifierSeparator.ENTITY_INSTANCE_SEPARATOR),
            ALPHANUM_VALUE);

    /** A legacy PDB id: a digit followed by 3 alphanumeric characters, e.g. {@code 1abc}. */
    public static final Pattern PDB_ID_REGEX = Pattern.compile("^" + PDB_ID_REGEX_VALUE + "$");

    /** An extended PDB id: {@code pdb_} followed by 8 lowercase alphanumeric characters, e.g. {@code pdb_00001abc}. */
    public static final Pattern EXT_PDB_ID_REGEX = Pattern.compile("^" + EXT_PDB_ID_REGEX_VALUE + "$");

    /** A legacy PDB id with an optional assembly, interface, entity or entity instance suffix. */
    public static final Pattern PDB_ID_WITH_SUFFIX_REGEX =
            Pattern.compile("^" + PDB_ID_REGEX_VALUE + SUFFIX_REGEX_VALUE + "$");

    /** An extended PDB id with an optional assembly, interface, entity or entity instance suffix. */
    public static final Pattern EXT_PDB_ID_WITH_SUFFIX_REGEX =
            Pattern.compile("^" + EXT_PDB_ID_REGEX_VALUE + SUFFIX_REGEX_VALUE + "$");

    private IdentifierRegex() {}

    /**
     * Tells whether the given string is a legacy PDB id: a digit followed by 3 alphanumeric
     * characters, in either case (e.g. {@code 1abc}, {@code 1ABC}).
     *
     * <p>Suffixes are not accepted: use {@link #PDB_ID_WITH_SUFFIX_REGEX} for those.
     *
     * @param id the string to test, can be null
     * @return true if the string is a legacy PDB id, false otherwise or if id is null
     * @since 3.2.0
     */
    public static boolean isLegacyPdbId(String id) {
        return id != null && PDB_ID_REGEX.matcher(id).matches();
    }

    /**
     * Tells whether the given string is an extended PDB id: the prefix {@code pdb_} followed by 8
     * lowercase alphanumeric characters (e.g. {@code pdb_00001abc}). Uppercase is not accepted.
     *
     * <p>Suffixes are not accepted: use {@link #EXT_PDB_ID_WITH_SUFFIX_REGEX} for those.
     *
     * @param id the string to test, can be null
     * @return true if the string is an extended PDB id, false otherwise or if id is null
     * @since 3.2.0
     */
    public static boolean isExtPdbId(String id) {
        return id != null && EXT_PDB_ID_REGEX.matcher(id).matches();
    }

    /**
     * Tells whether the given string is a PDB id in either of the supported flavours, i.e. whether
     * {@link #isLegacyPdbId(String)} or {@link #isExtPdbId(String)} holds.
     *
     * @param id the string to test, can be null
     * @return true if the string is a legacy or extended PDB id, false otherwise or if id is null
     * @since 3.2.0
     */
    public static boolean isAnyPdbId(String id) {
        return isLegacyPdbId(id) || isExtPdbId(id);
    }

    /**
     * Identifies the identifier flavour from the input.
     *
     * <p>Extended identifiers are recognized case-insensitively.
     *
     * @param pdbId the input identifier
     * @return {@link PdbIdFlavor#EXTENDED} for extended IDs; {@link PdbIdFlavor#LEGACY} for legacy IDs
     * @throws IllegalArgumentException if {@code pdbId} is null or not a valid legacy/extended PDB id
     */
    public static PdbIdFlavor identifyFlavor(String pdbId) {
        if (pdbId == null) {
            throw new IllegalArgumentException("Invalid PDB ID: null");
        }

        String id = pdbId.toLowerCase(Locale.ROOT);

        if (IdentifierRegex.isLegacyPdbId(id)) return PdbIdFlavor.LEGACY;
        if (IdentifierRegex.isExtPdbId(id))    return PdbIdFlavor.EXTENDED;

        throw new IllegalArgumentException("Invalid PDB ID: " + pdbId);
    }

    /**
     * Converts a PDB ID from an external source to the desired identifier flavor targetFlavor
     * @param externalId the PDB ID received from an external resource
     * @param targetFlavor the backend flavor to convert to
     * @return the normalized ID of the database identifier flavor
     */
    public static String normalizePdbId(String externalId, PdbIdFlavor targetFlavor) {
        if (externalId == null) return null;
        String trimmed = externalId.trim();
        boolean isLegacy = IdentifierRegex.isLegacyPdbId(trimmed);
        boolean isExtended = IdentifierRegex.isExtPdbId(trimmed.toLowerCase());

        if (targetFlavor == PdbIdFlavor.EXTENDED) {
            if (isLegacy) return EXTENDED_PREFIX + trimmed.toLowerCase();
            if (isExtended) return trimmed.toLowerCase();
        } else {
            if (isExtended) return trimmed.substring(EXTENDED_PREFIX.length()).toUpperCase();
            if (isLegacy) return trimmed.toUpperCase();
        }
        throw new IllegalArgumentException("Invalid PDB ID: " + externalId);
    }
}
