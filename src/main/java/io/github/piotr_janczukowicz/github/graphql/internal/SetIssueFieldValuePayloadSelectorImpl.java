package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SetIssueFieldValuePayloadSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SetIssueFieldValuePayload}; used by the generated selection code only. */
final class SetIssueFieldValuePayloadSelectorImpl implements SetIssueFieldValuePayloadSelector {

    private final Cursor cursor;

    SetIssueFieldValuePayloadSelectorImpl(final Cursor cursor) {
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
    public <R> List<R> issueFieldValues(final Function<IssueFieldValueSelector, R> selection) {
        return cursor.list("issueFieldValues", child -> selection.apply(new IssueFieldValueSelectorImpl(child)));
    }
}
