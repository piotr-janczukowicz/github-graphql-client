package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code RequiredReviewerConfiguration}. */
public interface RequiredReviewerConfigurationSelector {

    List<String> filePatterns();

    int minimumApprovals();

    String reviewerId();
}
