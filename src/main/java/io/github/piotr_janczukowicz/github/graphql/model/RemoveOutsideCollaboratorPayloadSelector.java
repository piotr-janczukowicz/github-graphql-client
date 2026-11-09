package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveOutsideCollaboratorPayload}. */
public interface RemoveOutsideCollaboratorPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R removedUser(Function<UserSelector, R> selection);
}
