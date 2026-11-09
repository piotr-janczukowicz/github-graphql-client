package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateCheckRunPayload}. */
public interface CreateCheckRunPayloadSelector {

    <R> @Nullable R checkRun(Function<CheckRunSelector, R> selection);

    @Nullable String clientMutationId();
}
