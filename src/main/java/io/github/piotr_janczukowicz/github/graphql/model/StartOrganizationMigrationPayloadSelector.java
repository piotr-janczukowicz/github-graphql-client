package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code StartOrganizationMigrationPayload}. */
public interface StartOrganizationMigrationPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R orgMigration(Function<OrganizationMigrationSelector, R> selection);
}
