package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;

/** Selection of the GraphQL type {@code RateLimit}. */
public interface RateLimitSelector {

    int cost();

    int limit();

    int nodeCount();

    int remaining();

    Instant resetAt();

    int used();
}
