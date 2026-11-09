package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CopilotEndpoints}. */
public interface CopilotEndpointsSelector {

    String api();

    @Nullable String exp();

    String originTracker();

    String proxy();

    String telemetry();
}
