package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CopilotCodeReviewSource}. */
public interface CopilotCodeReviewSourceSelector {

    CopilotCodeReviewSourceKind kind();

    String name();

    @Nullable String path();
}
