package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PromoteRepositoryCustomPropertyPayload}. */
public interface PromoteRepositoryCustomPropertyPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R repositoryCustomProperty(Function<RepositoryCustomPropertySelector, R> selection);
}
