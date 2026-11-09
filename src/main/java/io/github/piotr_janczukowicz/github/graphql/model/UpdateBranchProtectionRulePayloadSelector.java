package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateBranchProtectionRulePayload}. */
public interface UpdateBranchProtectionRulePayloadSelector {

    <R> @Nullable R branchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    @Nullable String clientMutationId();
}
