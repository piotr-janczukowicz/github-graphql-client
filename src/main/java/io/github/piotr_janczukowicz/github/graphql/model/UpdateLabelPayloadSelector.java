package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateLabelPayload}. */
public interface UpdateLabelPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R label(Function<LabelSelector, R> selection);
}
