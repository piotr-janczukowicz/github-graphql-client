package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code GistComment}; used by the generated selection code only. */
final class GistCommentSelectorImpl implements GistCommentSelector {

    private final Cursor cursor;

    GistCommentSelectorImpl(final Cursor cursor) {
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
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public boolean createdViaEmail() {
        return cursor.getRequired("createdViaEmail", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R gist(final Function<GistSelector, R> selection) {
        return cursor.objectRequired("gist", child -> selection.apply(new GistSelectorImpl(child)));
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
    public @Nullable Instant publishedAt() {
        return cursor.get("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> userContentEdits(final Paging paging, final Function<UserContentEditSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "userContentEdits",
                child -> selection.apply(new UserContentEditSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
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
