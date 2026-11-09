package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestReview}; used by the generated selection code only. */
final class PullRequestReviewSelectorImpl implements PullRequestReviewSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    PullRequestReviewSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R author(final Function<ActorSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public CommentAuthorAssociation authorAssociation() {
        return cursor.getRequired(
                "authorAssociation",
                ScalarType.enumeration(CommentAuthorAssociation::fromWire, CommentAuthorAssociation.COLLABORATOR));
    }

    @Override
    public boolean authorCanPushToRepository() {
        return cursor.getRequired("authorCanPushToRepository", ScalarType.BOOLEAN);
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String bodyHTML() {
        return cursor.getRequired("bodyHTML", ScalarType.STRING);
    }

    @Override
    public String bodyText() {
        return cursor.getRequired("bodyText", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<PullRequestReviewCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new PullRequestReviewCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R commit(final Function<CommitSelector, R> selection) {
        return cursor.object("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public boolean createdViaEmail() {
        return cursor.getRequired("createdViaEmail", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2024-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean includesCreatedEdit() {
        return cursor.getRequired("includesCreatedEdit", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isMinimized() {
        return cursor.getRequired("isMinimized", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant lastEditedAt() {
        return cursor.get("lastEditedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String minimizedReason() {
        return cursor.get("minimizedReason", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> onBehalfOf(final Paging paging, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "onBehalfOf",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public @Nullable Instant publishedAt() {
        return cursor.get("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging,
            final PullRequestReviewReactionsFilter arguments,
            final Function<ReactionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "reactions",
                child -> selection.apply(new ReactionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("content", "ReactionContent", arguments.content()),
                Argument.of(
                        "orderBy",
                        "ReactionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> reactions(final Paging paging, final Function<ReactionSelector, R> selection) {
        return reactions(
                paging, PullRequestReviewReactionsFilterBuilder.builder().build(), selection);
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
    public PullRequestReviewState state() {
        return cursor.getRequired(
                "state", ScalarType.enumeration(PullRequestReviewState::fromWire, PullRequestReviewState.APPROVED));
    }

    @Override
    public @Nullable Instant submittedAt() {
        return cursor.get("submittedAt", ScalarType.INSTANT);
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
    public <R> Page<R> userContentEdits(final Paging paging, final Function<UserContentEditSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "userContentEdits",
                child -> selection.apply(new UserContentEditSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean viewerCanDelete() {
        return cursor.getRequired("viewerCanDelete", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanMinimize() {
        return cursor.getRequired("viewerCanMinimize", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUnminimize() {
        return cursor.getRequired("viewerCanUnminimize", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdate() {
        return cursor.getRequired("viewerCanUpdate", ScalarType.BOOLEAN);
    }

    @Override
    public List<CommentCannotUpdateReason> viewerCannotUpdateReasons() {
        return cursor.scalarListRequired(
                "viewerCannotUpdateReasons",
                ScalarType.enumeration(CommentCannotUpdateReason::fromWire, CommentCannotUpdateReason.ARCHIVED));
    }

    @Override
    public boolean viewerDidAuthor() {
        return cursor.getRequired("viewerDidAuthor", ScalarType.BOOLEAN);
    }
}
