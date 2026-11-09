package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddBlockedByPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddBlockedByPayload}; used by the generated selection code only. */
final class AddBlockedByPayloadSelectorImpl implements AddBlockedByPayloadSelector {

    private final Cursor cursor;

    AddBlockedByPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R blockingIssue(final Function<IssueSelector, R> selection) {
        return cursor.object("blockingIssue", child -> selection.apply(new IssueSelectorImpl(child)));
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
