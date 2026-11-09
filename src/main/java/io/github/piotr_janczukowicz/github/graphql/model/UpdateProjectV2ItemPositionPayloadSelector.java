package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2ItemPositionPayload}. */
public interface UpdateProjectV2ItemPositionPayloadSelector {

    @Nullable String clientMutationId();

    <R> Page<R> items(Paging paging, Function<ProjectV2ItemSelector, R> selection);
}
