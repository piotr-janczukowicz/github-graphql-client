package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestReviewsByLoginPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserEdgeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RequestReviewsByLoginPayload}; used by the generated selection code only. */
final class RequestReviewsByLoginPayloadSelectorImpl implements RequestReviewsByLoginPayloadSelector {

    private final Cursor cursor;

    RequestReviewsByLoginPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R requestedReviewersEdge(final Function<UserEdgeSelector, R> selection) {
        return cursor.object("requestedReviewersEdge", child -> selection.apply(new UserEdgeSelectorImpl(child)));
    }
}
