package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility}. {@link #UNRECOGNIZED}
 * stands for a value GitHub added after this version.
 */
public enum OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility {
    ALL,
    INTERNAL,
    NONE,
    PRIVATE,
    PRIVATE_INTERNAL,
    PUBLIC,
    PUBLIC_INTERNAL,
    PUBLIC_PRIVATE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility>
            WIRE_INDEX = EnumUtils.index(
                    OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility.class,
                    OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
