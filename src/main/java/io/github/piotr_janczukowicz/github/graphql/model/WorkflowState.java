package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/** The GraphQL enum {@code WorkflowState}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version. */
public enum WorkflowState {
    ACTIVE,
    DELETED,
    DISABLED_FORK,
    DISABLED_INACTIVITY,
    DISABLED_MANUALLY,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<WorkflowState> WIRE_INDEX =
            EnumUtils.index(WorkflowState.class, WorkflowState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static WorkflowState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
