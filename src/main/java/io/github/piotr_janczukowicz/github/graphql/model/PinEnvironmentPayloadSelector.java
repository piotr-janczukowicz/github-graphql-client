package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PinEnvironmentPayload}. */
public interface PinEnvironmentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R environment(Function<EnvironmentSelector, R> selection);

    <R> @Nullable R pinnedEnvironment(Function<PinnedEnvironmentSelector, R> selection);
}
