package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddUpvotePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VotableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddUpvotePayload}; used by the generated selection code only. */
final class AddUpvotePayloadSelectorImpl implements AddUpvotePayloadSelector {

    private final Cursor cursor;

    AddUpvotePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R subject(final Function<VotableSelector, R> selection) {
        return cursor.object("subject", child -> selection.apply(new VotableSelectorImpl(child)));
    }
}
