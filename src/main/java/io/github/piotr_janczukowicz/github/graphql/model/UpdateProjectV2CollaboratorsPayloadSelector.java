package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2CollaboratorsPayload}. */
public interface UpdateProjectV2CollaboratorsPayloadSelector {

    @Nullable String clientMutationId();

    <R> Page<R> collaborators(Paging paging, Function<ProjectV2ActorSelector, R> selection);
}
