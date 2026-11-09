package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldIterationSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code ProjectV2IterationFieldConfiguration}; used by the generated selection code
 * only.
 */
final class ProjectV2IterationFieldConfigurationSelectorImpl implements ProjectV2IterationFieldConfigurationSelector {

    private final Cursor cursor;

    ProjectV2IterationFieldConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> completedIterations(final Function<ProjectV2IterationFieldIterationSelector, R> selection) {
        return cursor.listRequired(
                "completedIterations",
                child -> selection.apply(new ProjectV2IterationFieldIterationSelectorImpl(child)));
    }

    @Override
    public int duration() {
        return cursor.getRequired("duration", ScalarType.INT);
    }

    @Override
    public <R> List<R> iterations(final Function<ProjectV2IterationFieldIterationSelector, R> selection) {
        return cursor.listRequired(
                "iterations", child -> selection.apply(new ProjectV2IterationFieldIterationSelectorImpl(child)));
    }

    @Override
    public int startDay() {
        return cursor.getRequired("startDay", ScalarType.INT);
    }
}
