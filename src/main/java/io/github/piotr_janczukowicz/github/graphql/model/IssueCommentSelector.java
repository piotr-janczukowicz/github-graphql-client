package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueComment}. */
public interface IssueCommentSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    boolean includesCreatedEdit();

    boolean isMinimized();

    @Nullable Boolean isPinned();

    <R> R issue(Function<IssueSelector, R> selection);

    @Nullable Instant lastEditedAt();

    @Nullable String minimizedReason();

    @Nullable Instant pinnedAt();

    <R> @Nullable R pinnedBy(Function<UserSelector, R> selection);

    @Nullable Instant publishedAt();

    <R> @Nullable R pullRequest(Function<PullRequestSelector, R> selection);

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(
            Paging paging, IssueCommentReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    Instant updatedAt();

    String url();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanDelete();

    boolean viewerCanMinimize();

    boolean viewerCanPin();

    boolean viewerCanReact();

    boolean viewerCanUnminimize();

    boolean viewerCanUnpin();

    boolean viewerCanUpdate();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();
}
