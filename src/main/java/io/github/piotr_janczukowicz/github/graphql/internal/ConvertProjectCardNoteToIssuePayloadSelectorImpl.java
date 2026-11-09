package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ConvertProjectCardNoteToIssuePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ConvertProjectCardNoteToIssuePayload}; used by the generated selection code
 * only.
 */
final class ConvertProjectCardNoteToIssuePayloadSelectorImpl implements ConvertProjectCardNoteToIssuePayloadSelector {

    private final Cursor cursor;

    ConvertProjectCardNoteToIssuePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectCard(final Function<ProjectCardSelector, R> selection) {
        return cursor.object("projectCard", child -> selection.apply(new ProjectCardSelectorImpl(child)));
    }
}
