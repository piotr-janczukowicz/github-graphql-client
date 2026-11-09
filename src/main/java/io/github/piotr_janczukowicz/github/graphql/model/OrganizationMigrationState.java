package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code OrganizationMigrationState}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum OrganizationMigrationState {
    FAILED,
    FAILED_VALIDATION,
    IN_PROGRESS,
    NOT_STARTED,
    PENDING_VALIDATION,
    POST_REPO_MIGRATION,
    PRE_REPO_MIGRATION,
    QUEUED,
    REPO_MIGRATION,
    SUCCEEDED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<OrganizationMigrationState> WIRE_INDEX =
            EnumUtils.index(OrganizationMigrationState.class, OrganizationMigrationState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static OrganizationMigrationState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
