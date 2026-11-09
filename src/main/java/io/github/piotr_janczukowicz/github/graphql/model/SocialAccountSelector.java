package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code SocialAccount}. */
public interface SocialAccountSelector {

    String displayName();

    SocialAccountProvider provider();

    String url();
}
