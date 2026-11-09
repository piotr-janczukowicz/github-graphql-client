package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PropertyTargetDefinitionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPropertyConditionTargetSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code RepositoryPropertyConditionTarget}; used by the generated selection code only.
 */
final class RepositoryPropertyConditionTargetSelectorImpl implements RepositoryPropertyConditionTargetSelector {

    private final Cursor cursor;

    RepositoryPropertyConditionTargetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> exclude(final Function<PropertyTargetDefinitionSelector, R> selection) {
        return cursor.listRequired(
                "exclude", child -> selection.apply(new PropertyTargetDefinitionSelectorImpl(child)));
    }

    @Override
    public <R> List<R> include(final Function<PropertyTargetDefinitionSelector, R> selection) {
        return cursor.listRequired(
                "include", child -> selection.apply(new PropertyTargetDefinitionSelectorImpl(child)));
    }
}
