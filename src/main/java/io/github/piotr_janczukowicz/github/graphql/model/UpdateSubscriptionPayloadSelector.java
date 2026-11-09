package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateSubscriptionPayload}. */
public interface UpdateSubscriptionPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R subscribable(Function<SubscribableSelector, R> selection);
}
