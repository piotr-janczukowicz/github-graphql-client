package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectCardPayload}. */
public interface DeleteProjectCardPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R column(Function<ProjectColumnSelector, R> selection);

    @Nullable String deletedCardId();
}
