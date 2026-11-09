package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Environment}. */
public interface EnvironmentSelector {

    @Nullable Integer databaseId();

    String id();

    @Nullable Boolean isPinned();

    <R> @Nullable R latestCompletedDeployment(Function<DeploymentSelector, R> selection);

    String name();

    @Nullable Integer pinnedPosition();

    <R> Page<R> protectionRules(Paging paging, Function<DeploymentProtectionRuleSelector, R> selection);
}
