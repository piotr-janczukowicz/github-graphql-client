package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code SponsorsActivityAction}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum SponsorsActivityAction {
    CANCELLED_SPONSORSHIP,
    NEW_SPONSORSHIP,
    PENDING_CHANGE,
    REFUND,
    SPONSOR_MATCH_DISABLED,
    TIER_CHANGE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<SponsorsActivityAction> WIRE_INDEX =
            EnumUtils.index(SponsorsActivityAction.class, SponsorsActivityAction::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static SponsorsActivityAction fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
