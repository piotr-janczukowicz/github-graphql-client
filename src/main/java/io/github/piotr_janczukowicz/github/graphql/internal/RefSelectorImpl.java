package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefAssociatedPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RefAssociatedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RefRulesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RefRulesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefUpdateRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Ref}; used by the generated selection code only. */
final class RefSelectorImpl implements RefSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    RefSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> associatedPullRequests(
            final Paging paging,
            final RefAssociatedPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "associatedPullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of("baseRefName", STRING, arguments.baseRefName()),
                Argument.of("headRefName", STRING, arguments.headRefName()),
                Argument.of("labels", "[String!]", arguments.labels()),
                Argument.of(
                        "orderBy",
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("states", "[PullRequestState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> associatedPullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return associatedPullRequests(
                paging, RefAssociatedPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R branchProtectionRule(final Function<BranchProtectionRuleSelector, R> selection) {
        return cursor.object(
                "branchProtectionRule", child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R compare(final String headRef, final Function<ComparisonSelector, R> selection) {
        requireNonNull(headRef, "headRef");
        return cursor.object(
                "compare",
                child -> selection.apply(new ComparisonSelectorImpl(child)),
                Argument.of("headRef", "String!", headRef));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String prefix() {
        return cursor.getRequired("prefix", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R refUpdateRule(final Function<RefUpdateRuleSelector, R> selection) {
        return cursor.object("refUpdateRule", child -> selection.apply(new RefUpdateRuleSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> Page<R> rules(
            final Paging paging, final RefRulesFilter arguments, final Function<RepositoryRuleSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "rules",
                child -> selection.apply(new RepositoryRuleSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "RepositoryRuleOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> rules(final Paging paging, final Function<RepositoryRuleSelector, R> selection) {
        return rules(paging, RefRulesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R target(final Function<GitObjectSelector, R> selection) {
        return cursor.object("target", child -> selection.apply(new GitObjectSelectorImpl(child)));
    }
}
