package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrgRemoveMemberAuditEntryReason}. {@link #UNRECOGNIZED} stands for a value GitHub added after
 * this version.
 */
public enum OrgRemoveMemberAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY,
    TWO_FACTOR_ACCOUNT_RECOVERY,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    USER_ACCOUNT_DELETED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrgRemoveMemberAuditEntryReason> WIRE_INDEX =
            EnumUtils.index(OrgRemoveMemberAuditEntryReason.class, OrgRemoveMemberAuditEntryReason::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrgRemoveMemberAuditEntryReason fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
