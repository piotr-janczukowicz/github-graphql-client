package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DiffSide;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSubjectType;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestThreadCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestThreadCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestThread}; used by the generated selection code only. */
final class PullRequestThreadSelectorImpl implements PullRequestThreadSelector {

    private final Cursor cursor;

    PullRequestThreadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> comments(
            final Paging paging,
            final PullRequestThreadCommentsFilter arguments,
            final Function<PullRequestReviewCommentSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new PullRequestReviewCommentSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("skip", "Int", arguments.skip()));
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<PullRequestReviewCommentSelector, R> selection) {
        return comments(paging, PullRequestThreadCommentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public DiffSide diffSide() {
        return cursor.getRequired("diffSide", ScalarType.enumeration(DiffSide::fromWire, DiffSide.LEFT));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isCollapsed() {
        return cursor.getRequired("isCollapsed", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isOutdated() {
        return cursor.getRequired("isOutdated", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isResolved() {
        return cursor.getRequired("isResolved", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer line() {
        return cursor.get("line", ScalarType.INT);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R resolvedBy(final Function<UserSelector, R> selection) {
        return cursor.object("resolvedBy", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public @Nullable DiffSide startDiffSide() {
        return cursor.get("startDiffSide", ScalarType.enumeration(DiffSide::fromWire, DiffSide.LEFT));
    }

    @Override
    public @Nullable Integer startLine() {
        return cursor.get("startLine", ScalarType.INT);
    }

    @Override
    public PullRequestReviewThreadSubjectType subjectType() {
        return cursor.getRequired(
                "subjectType",
                ScalarType.enumeration(
                        PullRequestReviewThreadSubjectType::fromWire, PullRequestReviewThreadSubjectType.FILE));
    }

    @Override
    public boolean viewerCanReply() {
        return cursor.getRequired("viewerCanReply", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanResolve() {
        return cursor.getRequired("viewerCanResolve", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUnresolve() {
        return cursor.getRequired("viewerCanUnresolve", ScalarType.BOOLEAN);
    }
}
