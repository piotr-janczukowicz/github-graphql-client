package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BypassPullRequestAllowance}. */
public interface BypassPullRequestAllowanceSelector {

    <R> @Nullable R actor(Function<BranchActorAllowanceActorSelector, R> selection);

    <R> @Nullable R branchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    String id();
}
