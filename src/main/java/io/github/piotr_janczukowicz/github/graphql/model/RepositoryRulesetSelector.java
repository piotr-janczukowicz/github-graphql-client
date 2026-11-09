package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryRuleset}. */
public interface RepositoryRulesetSelector {

    <R> Page<R> bypassActors(Paging paging, Function<RepositoryRulesetBypassActorSelector, R> selection);

    <R> R conditions(Function<RepositoryRuleConditionsSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    RuleEnforcement enforcement();

    String id();

    String name();

    <R> Page<R> rules(
            Paging paging, RepositoryRulesetRulesFilter arguments, Function<RepositoryRuleSelector, R> selection);

    <R> Page<R> rules(Paging paging, Function<RepositoryRuleSelector, R> selection);

    <R> R source(Function<RuleSourceSelector, R> selection);

    @Nullable RepositoryRulesetTarget target();

    Instant updatedAt();
}
