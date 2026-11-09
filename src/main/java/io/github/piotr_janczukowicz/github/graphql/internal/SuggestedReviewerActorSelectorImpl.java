package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SuggestedReviewerActorSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code SuggestedReviewerActor}; used by the generated selection code only. */
final class SuggestedReviewerActorSelectorImpl implements SuggestedReviewerActorSelector {

    private final Cursor cursor;

    SuggestedReviewerActorSelectorImpl(final Cursor cursor) {
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
    public <R> R reviewer(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("reviewer", child -> selection.apply(new ActorSelectorImpl(child)));
    }
}
