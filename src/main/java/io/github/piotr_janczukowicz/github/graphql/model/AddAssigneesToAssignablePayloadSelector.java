package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddAssigneesToAssignablePayload}. */
public interface AddAssigneesToAssignablePayloadSelector {

    <R> @Nullable R assignable(Function<AssignableSelector, R> selection);

    @Nullable String clientMutationId();
}
