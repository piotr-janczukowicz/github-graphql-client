package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SuggestedReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code SuggestedReviewer}; used by the generated selection code only. */
final class SuggestedReviewerSelectorImpl implements SuggestedReviewerSelector {

    private final Cursor cursor;

    SuggestedReviewerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean isAuthor() {
        return cursor.getRequired("isAuthor", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isCommenter() {
        return cursor.getRequired("isCommenter", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R reviewer(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("reviewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
