package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectColumnPayload}. */
public interface DeleteProjectColumnPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String deletedColumnId();

    <R> @Nullable R project(Function<ProjectSelector, R> selection);
}
