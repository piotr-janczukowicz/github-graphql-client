package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewSeverityFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCopilotCodeReviewEffortSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCopilotCodeReviewSettingsSelector;
import java.util.List;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code RepositoryCopilotCodeReviewSettings}; used by the generated selection code
 * only.
 */
final class RepositoryCopilotCodeReviewSettingsSelectorImpl implements RepositoryCopilotCodeReviewSettingsSelector {

    private final Cursor cursor;

    RepositoryCopilotCodeReviewSettingsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<CopilotCodeReviewEffortLevel> availableReviewEfforts() {
        return cursor.scalarListRequired(
                "availableReviewEfforts",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }

    @Override
    public boolean customInstructionsEnabled() {
        return cursor.getRequired("customInstructionsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean mcpEnabled() {
        return cursor.getRequired("mcpEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R reviewEffort(final Function<RepositoryCopilotCodeReviewEffortSelector, R> selection) {
        return cursor.objectRequired(
                "reviewEffort", child -> selection.apply(new RepositoryCopilotCodeReviewEffortSelectorImpl(child)));
    }

    @Override
    public CopilotCodeReviewSeverityFilter severityFilter() {
        return cursor.getRequired(
                "severityFilter",
                ScalarType.enumeration(CopilotCodeReviewSeverityFilter::fromWire, CopilotCodeReviewSeverityFilter.LOW));
    }
}
