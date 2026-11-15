package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateEnterpriseCopilotCodeReviewPolicyPayload}. */
public interface UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R policy(Function<EnterpriseCopilotCodeReviewPolicySelector, R> selection);
}
