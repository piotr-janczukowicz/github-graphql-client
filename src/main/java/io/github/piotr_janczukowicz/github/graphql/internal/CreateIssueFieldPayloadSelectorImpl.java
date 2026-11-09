package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateIssueFieldPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateIssueFieldPayload}; used by the generated selection code only. */
final class CreateIssueFieldPayloadSelectorImpl implements CreateIssueFieldPayloadSelector {

    private final Cursor cursor;

    CreateIssueFieldPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R issueField(final Function<IssueFieldsSelector, R> selection) {
        return cursor.object("issueField", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }
}
