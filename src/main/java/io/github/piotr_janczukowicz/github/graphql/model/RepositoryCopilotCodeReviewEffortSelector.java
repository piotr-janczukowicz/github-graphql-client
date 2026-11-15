package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryCopilotCodeReviewEffort}. */
public interface RepositoryCopilotCodeReviewEffortSelector {

    @Nullable CopilotCodeReviewEffortLevel configured();

    CopilotCodeReviewEffortLevel effective();
}
