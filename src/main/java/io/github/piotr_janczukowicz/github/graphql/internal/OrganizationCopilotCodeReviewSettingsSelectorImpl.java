package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewDefaultEffortSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewSettingsSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code OrganizationCopilotCodeReviewSettings}; used by the generated selection code
 * only.
 */
final class OrganizationCopilotCodeReviewSettingsSelectorImpl implements OrganizationCopilotCodeReviewSettingsSelector {

    private final Cursor cursor;

    OrganizationCopilotCodeReviewSettingsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<CopilotCodeReviewEffortLevel> availableReviewEfforts() {
        return cursor.scalarListRequired(
                "availableReviewEfforts",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }

    @Override
    public <R> R defaultReviewEffort(final Function<OrganizationCopilotCodeReviewDefaultEffortSelector, R> selection) {
        return cursor.objectRequired(
                "defaultReviewEffort",
                child -> selection.apply(new OrganizationCopilotCodeReviewDefaultEffortSelectorImpl(child)));
    }
}
