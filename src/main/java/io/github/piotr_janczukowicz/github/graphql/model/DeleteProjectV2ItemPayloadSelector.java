package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteProjectV2ItemPayload}. */
public interface DeleteProjectV2ItemPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String deletedItemId();
}
