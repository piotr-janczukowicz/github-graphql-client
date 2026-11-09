package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code SquashMergeCommitMessage}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum SquashMergeCommitMessage {
    BLANK,
    COMMIT_MESSAGES,
    PR_BODY,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<SquashMergeCommitMessage> WIRE_INDEX =
            EnumUtils.index(SquashMergeCommitMessage.class, SquashMergeCommitMessage::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static SquashMergeCommitMessage fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
