package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateIssueFieldValuePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateIssueFieldValuePayload}; used by the generated selection code only. */
final class CreateIssueFieldValuePayloadSelectorImpl implements CreateIssueFieldValuePayloadSelector {

    private final Cursor cursor;

    CreateIssueFieldValuePayloadSelectorImpl(final Cursor cursor) {
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

    @Override
    public <R> @Nullable R issueFieldValue(final Function<IssueFieldValueSelector, R> selection) {
        return cursor.object("issueFieldValue", child -> selection.apply(new IssueFieldValueSelectorImpl(child)));
    }
}
