package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddProjectV2DraftIssuePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddProjectV2DraftIssuePayload}; used by the generated selection code only. */
final class AddProjectV2DraftIssuePayloadSelectorImpl implements AddProjectV2DraftIssuePayloadSelector {

    private final Cursor cursor;

    AddProjectV2DraftIssuePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectItem(final Function<ProjectV2ItemSelector, R> selection) {
        return cursor.object("projectItem", child -> selection.apply(new ProjectV2ItemSelectorImpl(child)));
    }
}
