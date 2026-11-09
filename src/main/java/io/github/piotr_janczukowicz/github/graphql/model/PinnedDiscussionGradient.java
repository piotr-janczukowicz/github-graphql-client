package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code PinnedDiscussionGradient}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum PinnedDiscussionGradient {
    BLUE_MINT,
    BLUE_PURPLE,
    PINK_BLUE,
    PURPLE_CORAL,
    RED_ORANGE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<PinnedDiscussionGradient> WIRE_INDEX =
            EnumUtils.index(PinnedDiscussionGradient.class, PinnedDiscussionGradient::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static PinnedDiscussionGradient fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
