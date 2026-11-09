package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Ref}. */
public interface RefSelector {

    <R> Page<R> associatedPullRequests(
            Paging paging, RefAssociatedPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> associatedPullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> @Nullable R branchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    <R> @Nullable R compare(String headRef, Function<ComparisonSelector, R> selection);

    String id();

    String name();

    String prefix();

    <R> @Nullable R refUpdateRule(Function<RefUpdateRuleSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    <R> Page<R> rules(Paging paging, RefRulesFilter arguments, Function<RepositoryRuleSelector, R> selection);

    <R> Page<R> rules(Paging paging, Function<RepositoryRuleSelector, R> selection);

    <R> @Nullable R target(Function<GitObjectSelector, R> selection);
}
