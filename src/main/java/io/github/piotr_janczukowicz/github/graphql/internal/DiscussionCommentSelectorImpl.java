package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DiscussionComment}; used by the generated selection code only. */
final class DiscussionCommentSelectorImpl implements DiscussionCommentSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    DiscussionCommentSelectorImpl(final Cursor cursor) {
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
    public @Nullable Instant deletedAt() {
        return cursor.get("deletedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R discussion(final Function<DiscussionSelector, R> selection) {
        return cursor.object("discussion", child -> selection.apply(new DiscussionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
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
    public boolean isAnswer() {
        return cursor.getRequired("isAnswer", ScalarType.BOOLEAN);
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
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging,
            final DiscussionCommentReactionsFilter arguments,
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
                paging, DiscussionCommentReactionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> replies(final Paging paging, final Function<DiscussionCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "replies",
                child -> selection.apply(new DiscussionCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R replyTo(final Function<DiscussionCommentSelector, R> selection) {
        return cursor.object("replyTo", child -> selection.apply(new DiscussionCommentSelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public int upvoteCount() {
        return cursor.getRequired("upvoteCount", ScalarType.INT);
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
    public boolean viewerCanMarkAsAnswer() {
        return cursor.getRequired("viewerCanMarkAsAnswer", ScalarType.BOOLEAN);
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
    public boolean viewerCanUnmarkAsAnswer() {
        return cursor.getRequired("viewerCanUnmarkAsAnswer", ScalarType.BOOLEAN);
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
    public boolean viewerCanUpvote() {
        return cursor.getRequired("viewerCanUpvote", ScalarType.BOOLEAN);
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

    @Override
    public boolean viewerHasUpvoted() {
        return cursor.getRequired("viewerHasUpvoted", ScalarType.BOOLEAN);
    }
}
