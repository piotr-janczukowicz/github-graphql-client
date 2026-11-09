package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortByFieldSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ProjectV2SortByField}; used by the generated selection code only. */
final class ProjectV2SortByFieldSelectorImpl implements ProjectV2SortByFieldSelector {

    private final Cursor cursor;

    ProjectV2SortByFieldSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public OrderDirection direction() {
        return cursor.getRequired("direction", ScalarType.enumeration(OrderDirection::fromWire, OrderDirection.ASC));
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }
}
