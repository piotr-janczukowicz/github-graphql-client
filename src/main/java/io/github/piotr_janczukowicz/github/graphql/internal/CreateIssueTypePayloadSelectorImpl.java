package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateIssueTypePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateIssueTypePayload}; used by the generated selection code only. */
final class CreateIssueTypePayloadSelectorImpl implements CreateIssueTypePayloadSelector {

    private final Cursor cursor;

    CreateIssueTypePayloadSelectorImpl(final Cursor cursor) {
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
