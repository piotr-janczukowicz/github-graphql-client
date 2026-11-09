package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortBySelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ProjectV2SortBy}; used by the generated selection code only. */
final class ProjectV2SortBySelectorImpl implements ProjectV2SortBySelector {

    private final Cursor cursor;

    ProjectV2SortBySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public OrderDirection direction() {
        return cursor.getRequired("direction", ScalarType.enumeration(OrderDirection::fromWire, OrderDirection.ASC));
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldSelector, R> selection) {
        return cursor.objectRequired("field", child -> selection.apply(new ProjectV2FieldSelectorImpl(child)));
    }
}
