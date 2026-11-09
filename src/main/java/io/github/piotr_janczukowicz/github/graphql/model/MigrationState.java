package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code MigrationState}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum MigrationState {
    FAILED,
    FAILED_VALIDATION,
    IN_PROGRESS,
    NOT_STARTED,
    PENDING_VALIDATION,
    QUEUED,
    SUCCEEDED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<MigrationState> WIRE_INDEX =
            EnumUtils.index(MigrationState.class, MigrationState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static MigrationState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
