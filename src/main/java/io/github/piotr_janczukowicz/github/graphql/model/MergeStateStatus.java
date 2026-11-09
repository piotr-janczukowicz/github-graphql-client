package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code MergeStateStatus}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum MergeStateStatus {
    BEHIND,
    BLOCKED,
    CLEAN,
    DIRTY,
    /**
     * @deprecated DRAFT state will be removed from this enum and `isDraft` should be used instead Use
     *     PullRequest.isDraft instead. Removal on 2021-01-01 UTC.
     */
    @Deprecated(forRemoval = true)
    DRAFT,
    HAS_HOOKS,
    UNKNOWN,
    UNSTABLE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<MergeStateStatus> WIRE_INDEX =
            EnumUtils.index(MergeStateStatus.class, MergeStateStatus::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static MergeStateStatus fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
