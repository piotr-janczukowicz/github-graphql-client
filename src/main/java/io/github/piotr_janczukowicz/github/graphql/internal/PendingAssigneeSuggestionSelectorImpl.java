package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingAssigneeSuggestionSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PendingAssigneeSuggestion}; used by the generated selection code only. */
final class PendingAssigneeSuggestionSelectorImpl implements PendingAssigneeSuggestionSelector {

    private final Cursor cursor;

    PendingAssigneeSuggestionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R assignee(final Function<AssigneeSelector, R> selection) {
        return cursor.object("assignee", child -> selection.apply(new AssigneeSelectorImpl(child)));
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
    public @Nullable String rationale() {
        return cursor.get("rationale", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }
}
