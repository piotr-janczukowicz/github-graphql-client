package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewRunnerConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayload}; used by the
 * generated selection code only.
 */
final class UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadSelectorImpl
        implements UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadSelector {

    private final Cursor cursor;

    UpdateOrganizationCopilotCodeReviewRunnerConfigurationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R runnerConfiguration(
            final Function<OrganizationCopilotCodeReviewRunnerConfigurationSelector, R> selection) {
        return cursor.object(
                "runnerConfiguration",
                child -> selection.apply(new OrganizationCopilotCodeReviewRunnerConfigurationSelectorImpl(child)));
    }
}
