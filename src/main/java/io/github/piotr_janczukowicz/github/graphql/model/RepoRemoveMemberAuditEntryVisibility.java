package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code RepoRemoveMemberAuditEntryVisibility}. {@link #UNRECOGNIZED} stands for a value GitHub added
 * after this version.
 */
public enum RepoRemoveMemberAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<RepoRemoveMemberAuditEntryVisibility> WIRE_INDEX =
            EnumUtils.index(RepoRemoveMemberAuditEntryVisibility.class, RepoRemoveMemberAuditEntryVisibility::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static RepoRemoveMemberAuditEntryVisibility fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
