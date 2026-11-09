package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReplaceActorsForAssignablePayload}. */
public interface ReplaceActorsForAssignablePayloadSelector {

    <R> @Nullable R assignable(Function<AssignableSelector, R> selection);

    @Nullable String clientMutationId();
}
