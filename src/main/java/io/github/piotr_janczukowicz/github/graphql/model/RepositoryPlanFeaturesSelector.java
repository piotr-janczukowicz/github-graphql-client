package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code RepositoryPlanFeatures}. */
public interface RepositoryPlanFeaturesSelector {

    boolean codeowners();

    boolean draftPullRequests();

    int maximumAssignees();

    int maximumManualReviewRequests();

    boolean teamReviewRequests();
}
