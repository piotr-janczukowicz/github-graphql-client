package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.PendingCloseSuggestionSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PendingCloseSuggestion}; used by the generated selection code only. */
final class PendingCloseSuggestionSelectorImpl implements PendingCloseSuggestionSelector {

    private final Cursor cursor;

    PendingCloseSuggestionSelectorImpl(final Cursor cursor) {
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
    public <R> @Nullable R duplicateOf(final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object("duplicateOf", child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)));
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
    public @Nullable IssueStateReason stateReason() {
        return cursor.get(
                "stateReason", ScalarType.enumeration(IssueStateReason::fromWire, IssueStateReason.COMPLETED));
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }
}
