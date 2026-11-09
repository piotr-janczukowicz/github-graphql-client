package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code GistComment}. */
public interface GistCommentSelector {

    <R> @Nullable R author(Function<ActorSelector, R> selection);

    CommentAuthorAssociation authorAssociation();

    String body();

    String bodyHTML();

    String bodyText();

    Instant createdAt();

    boolean createdViaEmail();

    @Nullable Integer databaseId();

    <R> @Nullable R editor(Function<ActorSelector, R> selection);

    <R> R gist(Function<GistSelector, R> selection);

    String id();

    boolean includesCreatedEdit();

    boolean isMinimized();

    @Nullable Instant lastEditedAt();

    @Nullable String minimizedReason();

    @Nullable Instant publishedAt();

    Instant updatedAt();

    <R> Page<R> userContentEdits(Paging paging, Function<UserContentEditSelector, R> selection);

    boolean viewerCanDelete();

    boolean viewerCanMinimize();

    boolean viewerCanUnminimize();

    boolean viewerCanUpdate();

    List<CommentCannotUpdateReason> viewerCannotUpdateReasons();

    boolean viewerDidAuthor();
}
