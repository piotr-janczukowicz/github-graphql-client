package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ConvertProjectV2DraftIssueItemToIssuePayload}. */
public interface ConvertProjectV2DraftIssueItemToIssuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R item(Function<ProjectV2ItemSelector, R> selection);
}
