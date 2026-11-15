package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code RepositoryCopilotCodeReviewSettings}. */
public interface RepositoryCopilotCodeReviewSettingsSelector {

    List<CopilotCodeReviewEffortLevel> availableReviewEfforts();

    boolean customInstructionsEnabled();

    boolean mcpEnabled();

    <R> R reviewEffort(Function<RepositoryCopilotCodeReviewEffortSelector, R> selection);

    CopilotCodeReviewSeverityFilter severityFilter();
}
