package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MarkProjectV2AsTemplatePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code MarkProjectV2AsTemplatePayload}; used by the generated selection code only.
 */
final class MarkProjectV2AsTemplatePayloadSelectorImpl implements MarkProjectV2AsTemplatePayloadSelector {

    private final Cursor cursor;

    MarkProjectV2AsTemplatePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2(final Function<ProjectV2Selector, R> selection) {
        return cursor.object("projectV2", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }
}
