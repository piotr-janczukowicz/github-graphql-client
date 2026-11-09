package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Discussion}. */
public interface DiscussionSelector {

    @Nullable LockReason activeLockReason();

    <R> @Nullable R answer(Function<DiscussionCommentSelector, R> selection);

    @Nullable Instant answerChosenAt();

    <R> @Nullable R answerChosenBy(Function<ActorSelector, R> selection);

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    <R> R category(Function<DiscussionCategorySelector, R> selection);

    boolean closed();

    @Nullable Instant closedAt();

    <R> Page<R> comments(Paging paging, Function<DiscussionCommentSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    @Nullable Boolean isAnswered();

    <R> Page<R> labels(Paging paging, DiscussionLabelsFilter arguments, Function<LabelSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);

    @Nullable Instant lastEditedAt();

    boolean locked();

    int number();

    <R> @Nullable R poll(Function<DiscussionPollSelector, R> selection);

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(Paging paging, DiscussionReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable DiscussionStateReason stateReason();

    String title();

    Instant updatedAt();

    int upvoteCount();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanClose();

    boolean viewerCanDelete();

    boolean viewerCanLabel();

    boolean viewerCanReact();

    boolean viewerCanReopen();

    boolean viewerCanSubscribe();

    boolean viewerCanUpdate();

    boolean viewerCanUpvote();

    boolean viewerDidAuthor();

    boolean viewerHasUpvoted();

    @Nullable SubscriptionState viewerSubscription();
}
