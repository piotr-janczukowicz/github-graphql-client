package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryRuleConditions}. */
public interface RepositoryRuleConditionsSelector {

    <R> @Nullable R organizationProperty(Function<OrganizationPropertyConditionTargetSelector, R> selection);

    <R> @Nullable R refName(Function<RefNameConditionTargetSelector, R> selection);

    <R> @Nullable R repositoryId(Function<RepositoryIdConditionTargetSelector, R> selection);

    <R> @Nullable R repositoryName(Function<RepositoryNameConditionTargetSelector, R> selection);

    <R> @Nullable R repositoryProperty(Function<RepositoryPropertyConditionTargetSelector, R> selection);
}
