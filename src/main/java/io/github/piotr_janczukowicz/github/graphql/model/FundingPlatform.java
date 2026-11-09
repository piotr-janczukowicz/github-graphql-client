package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code FundingPlatform}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum FundingPlatform {
    BUY_ME_A_COFFEE,
    COMMUNITY_BRIDGE,
    CUSTOM,
    GITHUB,
    ISSUEHUNT,
    KO_FI,
    LFX_CROWDFUNDING,
    LIBERAPAY,
    OPEN_COLLECTIVE,
    PATREON,
    POLAR,
    THANKS_DEV,
    TIDELIFT,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<FundingPlatform> WIRE_INDEX =
            EnumUtils.index(FundingPlatform.class, FundingPlatform::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static FundingPlatform fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
