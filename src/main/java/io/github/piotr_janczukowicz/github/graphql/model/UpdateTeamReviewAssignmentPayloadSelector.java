package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateTeamReviewAssignmentPayload}. */
public interface UpdateTeamReviewAssignmentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R team(Function<TeamSelector, R> selection);
}
