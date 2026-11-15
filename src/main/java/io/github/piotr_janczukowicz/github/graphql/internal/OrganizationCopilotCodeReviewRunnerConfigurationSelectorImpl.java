package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRunnerConfiguredBy;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewRunnerType;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewRunnerConfigurationSelector;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrganizationCopilotCodeReviewRunnerConfiguration}; used by the generated
 * selection code only.
 */
final class OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl
        implements OrganizationCopilotCodeReviewRunnerConfigurationSelector {

    private final Cursor cursor;

    OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean allowRepositoryCustomization() {
        return cursor.getRequired("allowRepositoryCustomization", ScalarType.BOOLEAN);
    }

    @Override
    public CopilotCodeReviewRunnerConfiguredBy configuredBy() {
        return cursor.getRequired(
                "configuredBy",
                ScalarType.enumeration(
                        CopilotCodeReviewRunnerConfiguredBy::fromWire,
                        CopilotCodeReviewRunnerConfiguredBy.CODE_REVIEW));
    }

    @Override
    public @Nullable String runnerGroupName() {
        return cursor.get("runnerGroupName", ScalarType.STRING);
    }

    @Override
    public List<String> runnerLabels() {
        return cursor.scalarListRequired("runnerLabels", ScalarType.STRING);
    }

    @Override
    public CopilotCodeReviewRunnerType runnerType() {
        return cursor.getRequired(
                "runnerType",
                ScalarType.enumeration(CopilotCodeReviewRunnerType::fromWire, CopilotCodeReviewRunnerType.LABELED));
    }
}
