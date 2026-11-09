package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateRepositoryRulesetPayload}. */
public interface CreateRepositoryRulesetPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R ruleset(Function<RepositoryRulesetSelector, R> selection);
}
