package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationCopilotCodeReviewDefaultEffort}. */
public interface OrganizationCopilotCodeReviewDefaultEffortSelector {

    @Nullable CopilotCodeReviewEffortLevel configured();

    boolean editable();

    CopilotCodeReviewEffortLevel effective();

    CopilotCodeReviewEffortLevel githubDefault();

    OrganizationCopilotCodeReviewPolicyManager managedBy();
}
