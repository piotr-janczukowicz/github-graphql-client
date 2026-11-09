package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrgRemoveBillingManagerAuditEntryReason}. {@link #UNRECOGNIZED} stands for a value GitHub
 * added after this version.
 */
public enum OrgRemoveBillingManagerAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrgRemoveBillingManagerAuditEntryReason> WIRE_INDEX = EnumUtils.index(
            OrgRemoveBillingManagerAuditEntryReason.class, OrgRemoveBillingManagerAuditEntryReason::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrgRemoveBillingManagerAuditEntryReason fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
