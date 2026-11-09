package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveRelatesToPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RemoveRelatesToPayload}; used by the generated selection code only. */
final class RemoveRelatesToPayloadSelectorImpl implements RemoveRelatesToPayloadSelector {

    private final Cursor cursor;

    RemoveRelatesToPayloadSelectorImpl(final Cursor cursor) {
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
    public <R> @Nullable R relatedIssue(final Function<IssueSelector, R> selection) {
        return cursor.object("relatedIssue", child -> selection.apply(new IssueSelectorImpl(child)));
    }
}
