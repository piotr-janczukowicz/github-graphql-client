package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RejectPendingIssueSuggestionsPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RejectPendingIssueSuggestionsPayload}; used by the generated selection code
 * only.
 */
final class RejectPendingIssueSuggestionsPayloadSelectorImpl implements RejectPendingIssueSuggestionsPayloadSelector {

    private final Cursor cursor;

    RejectPendingIssueSuggestionsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R issue(final Function<IssueSelector, R> selection) {
        return cursor.object("issue", child -> selection.apply(new IssueSelectorImpl(child)));
    }
}
