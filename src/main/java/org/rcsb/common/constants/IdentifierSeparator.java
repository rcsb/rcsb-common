package org.rcsb.common.constants;

/**
 * Created on 04/28/20.
 *
 * @author Yana Valasatava
 * @since 2.0.0
 */
public class IdentifierSeparator {

    private IdentifierSeparator() {}

    // the identifier separators as per document https://rcsbpdb.atlassian.net/wiki/spaces/S23PM/pages/101777442/Identifiers+-+Some+Conventions
    public static final String ENTITY_SEPARATOR = "_";
    public static final String ASSEMBLY_SEPARATOR = "-";
    public static final String ENTITY_INSTANCE_SEPARATOR = ".";
    public static final String INTERFACE_SEPARATOR = ".";
}
