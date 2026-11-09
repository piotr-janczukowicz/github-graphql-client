package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateTopicsPayload}. */
public interface UpdateTopicsPayloadSelector {

    @Nullable String clientMutationId();

    List<String> invalidTopicNames();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
