package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnlinkProjectV2FromTeamPayload}. */
public interface UnlinkProjectV2FromTeamPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R team(Function<TeamSelector, R> selection);
}
