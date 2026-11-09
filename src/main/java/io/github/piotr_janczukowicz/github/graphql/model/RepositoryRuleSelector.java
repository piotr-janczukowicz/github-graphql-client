package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryRule}. */
public interface RepositoryRuleSelector {

    String id();

    <R> @Nullable R parameters(Function<RuleParametersSelector, R> selection);

    <R> @Nullable R repositoryRuleset(Function<RepositoryRulesetSelector, R> selection);

    RepositoryRuleType type();
}
