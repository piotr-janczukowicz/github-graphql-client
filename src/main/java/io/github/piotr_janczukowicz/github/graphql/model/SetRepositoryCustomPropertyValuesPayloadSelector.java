package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SetRepositoryCustomPropertyValuesPayload}. */
public interface SetRepositoryCustomPropertyValuesPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
