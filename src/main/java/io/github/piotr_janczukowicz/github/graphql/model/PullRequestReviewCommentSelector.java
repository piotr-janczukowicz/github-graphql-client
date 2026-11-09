package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestReviewComment}. */
public interface PullRequestReviewCommentSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2024-07-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    String diffHunk();

    Instant draftedAt();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    boolean includesCreatedEdit();

    boolean isMinimized();

    @Nullable Instant lastEditedAt();

    @Nullable Integer line();

    @Nullable String minimizedReason();

    <R> @Nullable R originalCommit(Function<CommitSelector, R> selection);

    @Nullable Integer originalLine();

    /** @deprecated We are phasing out diff-relative positioning for PR comments Removal on 2023-10-01 UTC. */
    @Deprecated(forRemoval = true)
    int originalPosition();

    @Nullable Integer originalStartLine();

    boolean outdated();

    String path();

    /**
     * @deprecated We are phasing out diff-relative positioning for PR comments Use the `line` and `startLine` fields
     *     instead, which are file line numbers instead of diff line numbers Removal on 2023-10-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer position();

    @Nullable Instant publishedAt();

    <R> R pullRequest(Function<PullRequestSelector, R> selection);

    <R> @Nullable R pullRequestReview(Function<PullRequestReviewSelector, R> selection);

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(
            Paging paging, PullRequestReviewCommentReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> @Nullable R replyTo(Function<PullRequestReviewCommentSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable Integer startLine();

    PullRequestReviewCommentState state();

    PullRequestReviewThreadSubjectType subjectType();

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
