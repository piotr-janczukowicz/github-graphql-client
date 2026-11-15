package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateRepositoryCopilotCodeReviewSettingsPayload}. */
public interface UpdateRepositoryCopilotCodeReviewSettingsPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R settings(Function<RepositoryCopilotCodeReviewSettingsSelector, R> selection);
}
