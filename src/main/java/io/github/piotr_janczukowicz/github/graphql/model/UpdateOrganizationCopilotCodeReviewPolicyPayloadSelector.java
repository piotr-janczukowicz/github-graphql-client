package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateOrganizationCopilotCodeReviewPolicyPayload}. */
public interface UpdateOrganizationCopilotCodeReviewPolicyPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable OrganizationCopilotCodeReviewPolicyConflict conflict();

    <R> @Nullable R policy(Function<OrganizationCopilotCodeReviewPolicySelector, R> selection);
}
