package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ConvertProjectV2DraftIssueItemToIssuePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ConvertProjectV2DraftIssueItemToIssuePayload}; used by the generated selection
 * code only.
 */
final class ConvertProjectV2DraftIssueItemToIssuePayloadSelectorImpl
        implements ConvertProjectV2DraftIssueItemToIssuePayloadSelector {

    private final Cursor cursor;

    ConvertProjectV2DraftIssueItemToIssuePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R item(final Function<ProjectV2ItemSelector, R> selection) {
        return cursor.object("item", child -> selection.apply(new ProjectV2ItemSelectorImpl(child)));
    }
}
