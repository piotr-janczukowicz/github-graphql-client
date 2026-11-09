package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CloneProjectPayload}. */
public interface CloneProjectPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String jobStatusId();

    <R> @Nullable R project(Function<ProjectSelector, R> selection);
}
