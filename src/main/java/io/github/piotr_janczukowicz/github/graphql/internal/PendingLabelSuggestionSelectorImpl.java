package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingLabelSuggestionSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PendingLabelSuggestion}; used by the generated selection code only. */
final class PendingLabelSuggestionSelectorImpl implements PendingLabelSuggestionSelector {

    private final Cursor cursor;

    PendingLabelSuggestionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R label(final Function<LabelSelector, R> selection) {
        return cursor.object("label", child -> selection.apply(new LabelSelectorImpl(child)));
    }

    @Override
    public @Nullable String rationale() {
        return cursor.get("rationale", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }
}
