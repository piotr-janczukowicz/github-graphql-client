package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCopilotCodeReviewSettingsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateRepositoryCopilotCodeReviewSettingsPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateRepositoryCopilotCodeReviewSettingsPayload}; used by the generated
 * selection code only.
 */
final class UpdateRepositoryCopilotCodeReviewSettingsPayloadSelectorImpl
        implements UpdateRepositoryCopilotCodeReviewSettingsPayloadSelector {

    private final Cursor cursor;

    UpdateRepositoryCopilotCodeReviewSettingsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R settings(final Function<RepositoryCopilotCodeReviewSettingsSelector, R> selection) {
        return cursor.object(
                "settings", child -> selection.apply(new RepositoryCopilotCodeReviewSettingsSelectorImpl(child)));
    }
}
