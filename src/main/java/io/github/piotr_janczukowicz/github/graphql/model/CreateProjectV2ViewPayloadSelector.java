package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateProjectV2ViewPayload}. */
public interface CreateProjectV2ViewPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectV2View(Function<ProjectV2ViewSelector, R> selection);
}
