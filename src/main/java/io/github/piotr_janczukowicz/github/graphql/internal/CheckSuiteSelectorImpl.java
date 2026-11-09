package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteCheckRunsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteCheckRunsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteMatchingPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteMatchingPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CheckSuite}; used by the generated selection code only. */
final class CheckSuiteSelectorImpl implements CheckSuiteSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    CheckSuiteSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R app(final Function<AppSelector, R> selection) {
        return cursor.object("app", child -> selection.apply(new AppSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R branch(final Function<RefSelector, R> selection) {
        return cursor.object("branch", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> checkRuns(
            final Paging paging,
            final CheckSuiteCheckRunsFilter arguments,
            final Function<CheckRunSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "checkRuns",
                child -> selection.apply(new CheckRunSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "CheckRunFilter",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()));
    }

    @Override
    public <R> Page<R> checkRuns(final Paging paging, final Function<CheckRunSelector, R> selection) {
        return checkRuns(paging, CheckSuiteCheckRunsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R commit(final Function<CommitSelector, R> selection) {
        return cursor.objectRequired("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public @Nullable CheckConclusionState conclusion() {
        return cursor.get(
                "conclusion",
                ScalarType.enumeration(CheckConclusionState::fromWire, CheckConclusionState.ACTION_REQUIRED));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<UserSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> matchingPullRequests(
            final Paging paging,
            final CheckSuiteMatchingPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "matchingPullRequests",
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
    public <R> Page<R> matchingPullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return matchingPullRequests(
                paging, CheckSuiteMatchingPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R push(final Function<PushSelector, R> selection) {
        return cursor.object("push", child -> selection.apply(new PushSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public CheckStatusState status() {
        return cursor.getRequired(
                "status", ScalarType.enumeration(CheckStatusState::fromWire, CheckStatusState.COMPLETED));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R workflowRun(final Function<WorkflowRunSelector, R> selection) {
        return cursor.object("workflowRun", child -> selection.apply(new WorkflowRunSelectorImpl(child)));
    }
}
