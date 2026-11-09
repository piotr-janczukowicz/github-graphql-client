package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code BranchProtectionRuleConflict}. */
public interface BranchProtectionRuleConflictSelector {

    <R> @Nullable R branchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    <R> @Nullable R conflictingBranchProtectionRule(Function<BranchProtectionRuleSelector, R> selection);

    <R> @Nullable R ref(Function<RefSelector, R> selection);
}
