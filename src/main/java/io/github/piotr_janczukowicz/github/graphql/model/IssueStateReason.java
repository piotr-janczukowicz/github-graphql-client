package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code IssueStateReason}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum IssueStateReason {
    COMPLETED,
    DUPLICATE,
    NOT_PLANNED,
    REOPENED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<IssueStateReason> WIRE_INDEX =
            EnumUtils.index(IssueStateReason.class, IssueStateReason::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static IssueStateReason fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
