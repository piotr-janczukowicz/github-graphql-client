package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code FundingLink}. */
public interface FundingLinkSelector {

    FundingPlatform platform();

    String url();
}
