package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DraftIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2DraftIssuePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateProjectV2DraftIssuePayload}; used by the generated selection code only.
 */
final class UpdateProjectV2DraftIssuePayloadSelectorImpl implements UpdateProjectV2DraftIssuePayloadSelector {

    private final Cursor cursor;

    UpdateProjectV2DraftIssuePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R draftIssue(final Function<DraftIssueSelector, R> selection) {
        return cursor.object("draftIssue", child -> selection.apply(new DraftIssueSelectorImpl(child)));
    }
}
