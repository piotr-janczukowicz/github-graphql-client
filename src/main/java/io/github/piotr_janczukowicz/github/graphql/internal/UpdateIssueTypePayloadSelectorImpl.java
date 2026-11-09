package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateIssueTypePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateIssueTypePayload}; used by the generated selection code only. */
final class UpdateIssueTypePayloadSelectorImpl implements UpdateIssueTypePayloadSelector {

    private final Cursor cursor;

    UpdateIssueTypePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R issueType(final Function<IssueTypeSelector, R> selection) {
        return cursor.object("issueType", child -> selection.apply(new IssueTypeSelectorImpl(child)));
    }
}
