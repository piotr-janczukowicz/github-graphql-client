package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code OrganizationCopilotCodeReviewSettings}. */
public interface OrganizationCopilotCodeReviewSettingsSelector {

    List<CopilotCodeReviewEffortLevel> availableReviewEfforts();

    <R> R defaultReviewEffort(Function<OrganizationCopilotCodeReviewDefaultEffortSelector, R> selection);
}
