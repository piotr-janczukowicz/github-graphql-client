package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRequestReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequestCopilotCodeReviewPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewRequestSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RequestCopilotCodeReviewPayload}; used by the generated selection code only.
 */
final class RequestCopilotCodeReviewPayloadSelectorImpl implements RequestCopilotCodeReviewPayloadSelector {

    private final Cursor cursor;

    RequestCopilotCodeReviewPayloadSelectorImpl(final Cursor cursor) {
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
    public @Nullable CopilotCodeReviewRequestReason failureReason() {
        return cursor.get(
                "failureReason",
                ScalarType.enumeration(
                        CopilotCodeReviewRequestReason::fromWire, CopilotCodeReviewRequestReason.ACTOR_INELIGIBLE));
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R reviewRequest(final Function<ReviewRequestSelector, R> selection) {
        return cursor.object("reviewRequest", child -> selection.apply(new ReviewRequestSelectorImpl(child)));
    }

    @Override
    public @Nullable Boolean success() {
        return cursor.get("success", ScalarType.BOOLEAN);
    }
}
