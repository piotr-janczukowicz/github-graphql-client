package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code RepositoryLockReason}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum RepositoryLockReason {
    BILLING,
    MIGRATING,
    MOVING,
    RENAME,
    TRADE_RESTRICTION,
    TRANSFERRING_OWNERSHIP,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<RepositoryLockReason> WIRE_INDEX =
            EnumUtils.index(RepositoryLockReason.class, RepositoryLockReason::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static RepositoryLockReason fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
