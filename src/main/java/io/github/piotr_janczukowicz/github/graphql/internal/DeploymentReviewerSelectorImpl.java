package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeploymentReviewer}; used by the generated selection code only. */
final class DeploymentReviewerSelectorImpl implements DeploymentReviewerSelector {

    private final Cursor cursor;

    DeploymentReviewerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, DeploymentReviewerSelector.class, type, selection);
    }
}
