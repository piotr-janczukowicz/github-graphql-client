package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;

/** Selection of the GraphQL type {@code DeployKey}. */
public interface DeployKeySelector {

    Instant createdAt();

    boolean enabled();

    String id();

    String key();

    boolean readOnly();

    String title();

    boolean verified();
}
