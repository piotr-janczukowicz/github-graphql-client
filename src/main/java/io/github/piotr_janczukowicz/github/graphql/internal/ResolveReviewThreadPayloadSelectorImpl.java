package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ResolveReviewThreadPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ResolveReviewThreadPayload}; used by the generated selection code only. */
final class ResolveReviewThreadPayloadSelectorImpl implements ResolveReviewThreadPayloadSelector {

    private final Cursor cursor;

    ResolveReviewThreadPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R thread(final Function<PullRequestReviewThreadSelector, R> selection) {
        return cursor.object("thread", child -> selection.apply(new PullRequestReviewThreadSelectorImpl(child)));
    }
}
