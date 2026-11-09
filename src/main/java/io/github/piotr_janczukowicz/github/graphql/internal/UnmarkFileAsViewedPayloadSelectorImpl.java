package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnmarkFileAsViewedPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnmarkFileAsViewedPayload}; used by the generated selection code only. */
final class UnmarkFileAsViewedPayloadSelectorImpl implements UnmarkFileAsViewedPayloadSelector {

    private final Cursor cursor;

    UnmarkFileAsViewedPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
