package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveReactionPayloadSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RemoveReactionPayload}; used by the generated selection code only. */
final class RemoveReactionPayloadSelectorImpl implements RemoveReactionPayloadSelector {

    private final Cursor cursor;

    RemoveReactionPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R reaction(final Function<ReactionSelector, R> selection) {
        return cursor.object("reaction", child -> selection.apply(new ReactionSelectorImpl(child)));
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R subject(final Function<ReactableSelector, R> selection) {
        return cursor.object("subject", child -> selection.apply(new ReactableSelectorImpl(child)));
    }
}
