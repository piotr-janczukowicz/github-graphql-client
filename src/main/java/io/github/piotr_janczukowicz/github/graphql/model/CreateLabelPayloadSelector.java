package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateLabelPayload}. */
public interface CreateLabelPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R label(Function<LabelSelector, R> selection);
}
