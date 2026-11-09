package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnlinkProjectV2FromRepositoryPayload}. */
public interface UnlinkProjectV2FromRepositoryPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
