package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestedReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestRemovedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewRequestRemovedEvent}; used by the generated selection code only. */
final class ReviewRequestRemovedEventSelectorImpl implements ReviewRequestRemovedEventSelector {

    private final Cursor cursor;

    ReviewRequestRemovedEventSelectorImpl(final Cursor cursor) {
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R requestedReviewer(final Function<RequestedReviewerSelector, R> selection) {
        return cursor.object("requestedReviewer", child -> selection.apply(new RequestedReviewerSelectorImpl(child)));
    }
}
