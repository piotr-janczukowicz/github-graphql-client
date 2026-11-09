package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyTargetDefinitionSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code OrganizationPropertyConditionTarget}; used by the generated selection code
 * only.
 */
final class OrganizationPropertyConditionTargetSelectorImpl implements OrganizationPropertyConditionTargetSelector {

    private final Cursor cursor;

    OrganizationPropertyConditionTargetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> exclude(final Function<OrganizationPropertyTargetDefinitionSelector, R> selection) {
        return cursor.listRequired(
                "exclude", child -> selection.apply(new OrganizationPropertyTargetDefinitionSelectorImpl(child)));
    }

    @Override
    public <R> List<R> include(final Function<OrganizationPropertyTargetDefinitionSelector, R> selection) {
        return cursor.listRequired(
                "include", child -> selection.apply(new OrganizationPropertyTargetDefinitionSelectorImpl(child)));
    }
}
