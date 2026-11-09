package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RequestedReviewerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RequestedReviewer}; used by the generated selection code only. */
final class RequestedReviewerSelectorImpl implements RequestedReviewerSelector {

    private final Cursor cursor;

    RequestedReviewerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RequestedReviewerSelector.class, type, selection);
    }
}
