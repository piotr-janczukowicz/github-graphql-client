package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationPropertyConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefNameConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIdConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryNameConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPropertyConditionTargetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleConditionsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryRuleConditions}; used by the generated selection code only. */
final class RepositoryRuleConditionsSelectorImpl implements RepositoryRuleConditionsSelector {

    private final Cursor cursor;

    RepositoryRuleConditionsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R organizationProperty(
            final Function<OrganizationPropertyConditionTargetSelector, R> selection) {
        return cursor.object(
                "organizationProperty",
                child -> selection.apply(new OrganizationPropertyConditionTargetSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R refName(final Function<RefNameConditionTargetSelector, R> selection) {
        return cursor.object("refName", child -> selection.apply(new RefNameConditionTargetSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R repositoryId(final Function<RepositoryIdConditionTargetSelector, R> selection) {
        return cursor.object(
                "repositoryId", child -> selection.apply(new RepositoryIdConditionTargetSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R repositoryName(final Function<RepositoryNameConditionTargetSelector, R> selection) {
        return cursor.object(
                "repositoryName", child -> selection.apply(new RepositoryNameConditionTargetSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R repositoryProperty(final Function<RepositoryPropertyConditionTargetSelector, R> selection) {
        return cursor.object(
                "repositoryProperty",
                child -> selection.apply(new RepositoryPropertyConditionTargetSelectorImpl(child)));
    }
}
