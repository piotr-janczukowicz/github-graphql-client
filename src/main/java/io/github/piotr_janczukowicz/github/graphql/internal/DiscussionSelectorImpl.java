package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCategorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Discussion}; used by the generated selection code only. */
final class DiscussionSelectorImpl implements DiscussionSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    DiscussionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable LockReason activeLockReason() {
        return cursor.get("activeLockReason", ScalarType.enumeration(LockReason::fromWire, LockReason.OFF_TOPIC));
    }

    @Override
    public <R> @Nullable R answer(final Function<DiscussionCommentSelector, R> selection) {
        return cursor.object("answer", child -> selection.apply(new DiscussionCommentSelectorImpl(child)));
    }

    @Override
    public @Nullable Instant answerChosenAt() {
        return cursor.get("answerChosenAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R answerChosenBy(final Function<ActorSelector, R> selection) {
        return cursor.object("answerChosenBy", child -> selection.apply(new ActorSelectorImpl(child)));
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
    public <R> R category(final Function<DiscussionCategorySelector, R> selection) {
        return cursor.objectRequired("category", child -> selection.apply(new DiscussionCategorySelectorImpl(child)));
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<DiscussionCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new DiscussionCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean includesCreatedEdit() {
        return cursor.getRequired("includesCreatedEdit", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isAnswered() {
        return cursor.get("isAnswered", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging, final DiscussionLabelsFilter arguments, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, DiscussionLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant lastEditedAt() {
        return cursor.get("lastEditedAt", ScalarType.INSTANT);
    }

    @Override
    public boolean locked() {
        return cursor.getRequired("locked", ScalarType.BOOLEAN);
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R poll(final Function<DiscussionPollSelector, R> selection) {
        return cursor.object("poll", child -> selection.apply(new DiscussionPollSelectorImpl(child)));
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
            final DiscussionReactionsFilter arguments,
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
        return reactions(paging, DiscussionReactionsFilterBuilder.builder().build(), selection);
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
    public @Nullable DiscussionStateReason stateReason() {
        return cursor.get(
                "stateReason",
                ScalarType.enumeration(DiscussionStateReason::fromWire, DiscussionStateReason.DUPLICATE));
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
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
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanDelete() {
        return cursor.getRequired("viewerCanDelete", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanLabel() {
        return cursor.getRequired("viewerCanLabel", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
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
    public boolean viewerDidAuthor() {
        return cursor.getRequired("viewerDidAuthor", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerHasUpvoted() {
        return cursor.getRequired("viewerHasUpvoted", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }
}
