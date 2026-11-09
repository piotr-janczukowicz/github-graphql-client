package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReorderEnvironmentPayload}. */
public interface ReorderEnvironmentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R environment(Function<EnvironmentSelector, R> selection);
}
