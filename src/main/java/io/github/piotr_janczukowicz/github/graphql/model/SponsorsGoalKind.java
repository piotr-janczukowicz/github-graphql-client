package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code SponsorsGoalKind}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum SponsorsGoalKind {
    MONTHLY_SPONSORSHIP_AMOUNT,
    TOTAL_SPONSORS_COUNT,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<SponsorsGoalKind> WIRE_INDEX =
            EnumUtils.index(SponsorsGoalKind.class, SponsorsGoalKind::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static SponsorsGoalKind fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
