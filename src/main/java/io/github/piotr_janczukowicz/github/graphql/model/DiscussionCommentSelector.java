package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DiscussionComment}. */
public interface DiscussionCommentSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    @Nullable Instant deletedAt();

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    boolean isAnswer();

    boolean isMinimized();

    @Nullable Instant lastEditedAt();

    @Nullable String minimizedReason();

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(
            Paging paging, DiscussionCommentReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> Page<R> replies(Paging paging, Function<DiscussionCommentSelector, R> selection);

    <R> @Nullable R replyTo(Function<DiscussionCommentSelector, R> selection);

    String resourcePath();

    Instant updatedAt();

    int upvoteCount();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanDelete();

    boolean viewerCanMarkAsAnswer();

    boolean viewerCanMinimize();

    boolean viewerCanReact();

    boolean viewerCanUnmarkAsAnswer();

    boolean viewerCanUnminimize();

    boolean viewerCanUpdate();

    boolean viewerCanUpvote();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();

    boolean viewerHasUpvoted();
}
