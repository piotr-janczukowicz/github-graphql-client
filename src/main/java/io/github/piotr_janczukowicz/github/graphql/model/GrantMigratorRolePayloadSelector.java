package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code GrantMigratorRolePayload}. */
public interface GrantMigratorRolePayloadSelector {

    @Nullable String clientMutationId();

    @Nullable Boolean success();
}
