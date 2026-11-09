package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrganizationInvitationSource}. {@link #UNRECOGNIZED} stands for a value GitHub added after
 * this version.
 */
public enum OrganizationInvitationSource {
    ENTERPRISE_ORGANIZATION_CREATION,
    MEMBER,
    SCIM,
    UNKNOWN,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrganizationInvitationSource> WIRE_INDEX =
            EnumUtils.index(OrganizationInvitationSource.class, OrganizationInvitationSource::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrganizationInvitationSource fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
