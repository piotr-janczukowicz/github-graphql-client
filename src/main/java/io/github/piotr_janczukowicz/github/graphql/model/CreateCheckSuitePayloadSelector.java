package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateCheckSuitePayload}. */
public interface CreateCheckSuitePayloadSelector {

    <R> @Nullable R checkSuite(Function<CheckSuiteSelector, R> selection);

    @Nullable String clientMutationId();
}
