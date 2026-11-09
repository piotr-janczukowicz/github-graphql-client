package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewDismissedEvent}; used by the generated selection code only. */
final class ReviewDismissedEventSelectorImpl implements ReviewDismissedEventSelector {

    private final Cursor cursor;

    ReviewDismissedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String dismissalMessage() {
        return cursor.get("dismissalMessage", ScalarType.STRING);
    }

    @Override
    public @Nullable String dismissalMessageHTML() {
        return cursor.get("dismissalMessageHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public PullRequestReviewState previousReviewState() {
        return cursor.getRequired(
                "previousReviewState",
                ScalarType.enumeration(PullRequestReviewState::fromWire, PullRequestReviewState.APPROVED));
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pullRequestCommit(final Function<PullRequestCommitSelector, R> selection) {
        return cursor.object("pullRequestCommit", child -> selection.apply(new PullRequestCommitSelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R review(final Function<PullRequestReviewSelector, R> selection) {
        return cursor.object("review", child -> selection.apply(new PullRequestReviewSelectorImpl(child)));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
