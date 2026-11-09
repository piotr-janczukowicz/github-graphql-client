package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CommitComment}. */
public interface CommitCommentSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    boolean isMinimized();

    @Nullable Instant lastEditedAt();

    @Nullable String minimizedReason();

    @Nullable String path();

    @Nullable Integer position();

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(
            Paging paging, CommitCommentReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

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
