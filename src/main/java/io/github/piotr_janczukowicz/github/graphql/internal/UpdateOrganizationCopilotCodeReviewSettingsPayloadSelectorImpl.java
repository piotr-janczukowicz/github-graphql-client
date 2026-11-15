package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewSettingsConflict;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewSettingsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateOrganizationCopilotCodeReviewSettingsPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateOrganizationCopilotCodeReviewSettingsPayload}; used by the generated
 * selection code only.
 */
final class UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl
        implements UpdateOrganizationCopilotCodeReviewSettingsPayloadSelector {

    private final Cursor cursor;

    UpdateOrganizationCopilotCodeReviewSettingsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable OrganizationCopilotCodeReviewSettingsConflict conflict() {
        return cursor.get(
                "conflict",
                ScalarType.enumeration(
                        OrganizationCopilotCodeReviewSettingsConflict::fromWire,
                        OrganizationCopilotCodeReviewSettingsConflict.SETTING_NOT_EDITABLE));
    }

    @Override
    public <R> @Nullable R settings(final Function<OrganizationCopilotCodeReviewSettingsSelector, R> selection) {
        return cursor.object(
                "settings", child -> selection.apply(new OrganizationCopilotCodeReviewSettingsSelectorImpl(child)));
    }
}
