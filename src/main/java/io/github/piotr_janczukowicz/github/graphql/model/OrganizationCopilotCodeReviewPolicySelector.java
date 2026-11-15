package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationCopilotCodeReviewPolicy}. */
public interface OrganizationCopilotCodeReviewPolicySelector {

    @Nullable OrganizationCopilotCodeReviewPolicyState configuredState();

    boolean editable();

    OrganizationCopilotCodeReviewPolicyState effectiveState();

    OrganizationCopilotCodeReviewPolicyManager managedBy();
}
