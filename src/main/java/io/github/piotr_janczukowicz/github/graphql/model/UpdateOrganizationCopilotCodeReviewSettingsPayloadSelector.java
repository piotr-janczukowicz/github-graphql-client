package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateOrganizationCopilotCodeReviewSettingsPayload}. */
public interface UpdateOrganizationCopilotCodeReviewSettingsPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable OrganizationCopilotCodeReviewSettingsConflict conflict();

    <R> @Nullable R settings(Function<OrganizationCopilotCodeReviewSettingsSelector, R> selection);
}
