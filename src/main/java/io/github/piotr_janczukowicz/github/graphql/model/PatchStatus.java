package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/** The GraphQL enum {@code PatchStatus}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version. */
public enum PatchStatus {
    ADDED,
    CHANGED,
    COPIED,
    DELETED,
    MODIFIED,
    RENAMED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<PatchStatus> WIRE_INDEX =
            EnumUtils.index(PatchStatus.class, PatchStatus::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static PatchStatus fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
