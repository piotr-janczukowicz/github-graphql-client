package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestReview}. */
public interface PullRequestReviewSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    boolean authorCanPushToRepository();

    String body();

    String bodyHTML();

    String bodyText();

    <R> Page<R> comments(Paging paging, Function<PullRequestReviewCommentSelector, R> selection);

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2024-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    boolean includesCreatedEdit();

    boolean isMinimized();

    @Nullable Instant lastEditedAt();

    @Nullable String minimizedReason();

    <R> Page<R> onBehalfOf(Paging paging, Function<TeamSelector, R> selection);

    @Nullable Instant publishedAt();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(
            Paging paging, PullRequestReviewReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    PullRequestReviewState state();

    @Nullable Instant submittedAt();

    Instant updatedAt();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanDelete();

    boolean viewerCanMinimize();

    boolean viewerCanReact();

    boolean viewerCanUnminimize();

    boolean viewerCanUpdate();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();
}
