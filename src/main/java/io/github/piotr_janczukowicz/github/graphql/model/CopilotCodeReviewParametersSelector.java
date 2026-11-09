package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code CopilotCodeReviewParameters}. */
public interface CopilotCodeReviewParametersSelector {

    boolean reviewDraftPullRequests();

    boolean reviewOnPush();
}
