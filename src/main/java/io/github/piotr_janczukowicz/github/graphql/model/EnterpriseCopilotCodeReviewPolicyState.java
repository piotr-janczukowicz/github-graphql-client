package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code EnterpriseCopilotCodeReviewPolicyState}. {@link #UNRECOGNIZED} stands for a value GitHub
 * added after this version.
 */
public enum EnterpriseCopilotCodeReviewPolicyState {
    CONFIGURED_BY_ORGANIZATION_ADMINS,
    DISABLED_FOR_ALL_ORGANIZATIONS,
    ENABLED_FOR_ALL_ORGANIZATIONS,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<EnterpriseCopilotCodeReviewPolicyState> WIRE_INDEX =
            EnumUtils.index(EnterpriseCopilotCodeReviewPolicyState.class, EnterpriseCopilotCodeReviewPolicyState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static EnterpriseCopilotCodeReviewPolicyState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }

    /**
     * Returns the value name GraphQL expects when this constant is sent.
     *
     * @return the GraphQL value name
     * @throws IllegalArgumentException when this is {@link #UNRECOGNIZED}, which cannot be sent
     */
    public String wireValue() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("UNRECOGNIZED cannot be sent to GitHub");
        }
        return name();
    }
}
