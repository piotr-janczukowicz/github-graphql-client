package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeletePackageVersionPayload}. */
public interface DeletePackageVersionPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable Boolean success();
}
