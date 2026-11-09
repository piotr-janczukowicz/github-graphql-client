package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MilestonePullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.MilestonePullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Milestone}; used by the generated selection code only. */
final class MilestoneSelectorImpl implements MilestoneSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    MilestoneSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public int closedIssueCount() {
        return cursor.getRequired("closedIssueCount", ScalarType.INT);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public @Nullable String descriptionHTML() {
        return cursor.get("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant dueOn() {
        return cursor.get("dueOn", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> issues(
            final Paging paging, final MilestoneIssuesFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "issues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "IssueFilters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of("labels", "[String!]", arguments.labels()),
                Argument.of(
                        "orderBy",
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("states", "[IssueState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> issues(final Paging paging, final Function<IssueSelector, R> selection) {
        return issues(paging, MilestoneIssuesFilterBuilder.builder().build(), selection);
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public int openIssueCount() {
        return cursor.getRequired("openIssueCount", ScalarType.INT);
    }

    @Override
    public double progressPercentage() {
        return cursor.getRequired("progressPercentage", ScalarType.FLOAT);
    }

    @Override
    public <R> Page<R> pullRequests(
            final Paging paging,
            final MilestonePullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "pullRequests",
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
    public <R> Page<R> pullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return pullRequests(paging, MilestonePullRequestsFilterBuilder.builder().build(), selection);
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
    public MilestoneState state() {
        return cursor.getRequired("state", ScalarType.enumeration(MilestoneState::fromWire, MilestoneState.CLOSED));
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
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
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }
}
