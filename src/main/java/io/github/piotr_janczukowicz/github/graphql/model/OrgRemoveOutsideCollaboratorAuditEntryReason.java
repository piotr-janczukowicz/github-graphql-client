package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrgRemoveOutsideCollaboratorAuditEntryReason}. {@link #UNRECOGNIZED} stands for a value
 * GitHub added after this version.
 */
public enum OrgRemoveOutsideCollaboratorAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrgRemoveOutsideCollaboratorAuditEntryReason> WIRE_INDEX = EnumUtils.index(
            OrgRemoveOutsideCollaboratorAuditEntryReason.class, OrgRemoveOutsideCollaboratorAuditEntryReason::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrgRemoveOutsideCollaboratorAuditEntryReason fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
