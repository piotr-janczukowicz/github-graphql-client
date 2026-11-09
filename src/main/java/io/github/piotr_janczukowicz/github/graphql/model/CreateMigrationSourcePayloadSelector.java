package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateMigrationSourcePayload}. */
public interface CreateMigrationSourcePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R migrationSource(Function<MigrationSourceSelector, R> selection);
}
