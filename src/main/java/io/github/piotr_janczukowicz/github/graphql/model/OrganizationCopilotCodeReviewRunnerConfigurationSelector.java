package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code OrganizationCopilotCodeReviewRunnerConfiguration}. */
public interface OrganizationCopilotCodeReviewRunnerConfigurationSelector {

    boolean allowRepositoryCustomization();

    CopilotCodeReviewRunnerConfiguredBy configuredBy();

    @Nullable String runnerGroupName();

    List<String> runnerLabels();

    CopilotCodeReviewRunnerType runnerType();
}
