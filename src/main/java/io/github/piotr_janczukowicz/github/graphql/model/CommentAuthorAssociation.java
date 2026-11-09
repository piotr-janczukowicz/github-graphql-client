package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code CommentAuthorAssociation}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum CommentAuthorAssociation {
    COLLABORATOR,
    CONTRIBUTOR,
    FIRST_TIMER,
    FIRST_TIME_CONTRIBUTOR,
    MANNEQUIN,
    MEMBER,
    NONE,
    OWNER,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<CommentAuthorAssociation> WIRE_INDEX =
            EnumUtils.index(CommentAuthorAssociation.class, CommentAuthorAssociation::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static CommentAuthorAssociation fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
