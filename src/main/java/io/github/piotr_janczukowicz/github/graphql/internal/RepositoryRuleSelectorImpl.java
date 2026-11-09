package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleType;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RuleParametersSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryRule}; used by the generated selection code only. */
final class RepositoryRuleSelectorImpl implements RepositoryRuleSelector {

    private final Cursor cursor;

    RepositoryRuleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R parameters(final Function<RuleParametersSelector, R> selection) {
        return cursor.object("parameters", child -> selection.apply(new RuleParametersSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R repositoryRuleset(final Function<RepositoryRulesetSelector, R> selection) {
        return cursor.object("repositoryRuleset", child -> selection.apply(new RepositoryRulesetSelectorImpl(child)));
    }

    @Override
    public RepositoryRuleType type() {
        return cursor.getRequired(
                "type", ScalarType.enumeration(RepositoryRuleType::fromWire, RepositoryRuleType.AUTHORIZATION));
    }
}
