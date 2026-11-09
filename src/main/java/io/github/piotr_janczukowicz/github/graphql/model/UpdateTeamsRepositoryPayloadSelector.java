package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateTeamsRepositoryPayload}. */
public interface UpdateTeamsRepositoryPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    <R> List<R> teams(Function<TeamSelector, R> selection);
}
