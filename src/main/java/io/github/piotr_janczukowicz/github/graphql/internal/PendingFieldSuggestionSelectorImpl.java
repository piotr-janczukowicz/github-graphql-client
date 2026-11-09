package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingFieldSuggestionSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PendingFieldSuggestion}; used by the generated selection code only. */
final class PendingFieldSuggestionSelectorImpl implements PendingFieldSuggestionSelector {

    private final Cursor cursor;

    PendingFieldSuggestionSelectorImpl(final Cursor cursor) {
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
    public <R> @Nullable R issueField(final Function<IssueFieldsSelector, R> selection) {
        return cursor.object("issueField", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }

    @Override
    public @Nullable String rationale() {
        return cursor.get("rationale", ScalarType.STRING);
    }

    @Override
    public @Nullable String suggestedValue() {
        return cursor.get("suggestedValue", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }
}
