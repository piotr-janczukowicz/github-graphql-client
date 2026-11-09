package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateBranchProtectionRulePayload}. */
public interface CreateBranchProtectionRulePayloadSelector {

    <R> @Nullable R branchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    @Nullable String clientMutationId();
}
