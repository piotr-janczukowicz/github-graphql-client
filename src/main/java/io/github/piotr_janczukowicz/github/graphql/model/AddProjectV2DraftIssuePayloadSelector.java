package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddProjectV2DraftIssuePayload}. */
public interface AddProjectV2DraftIssuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectItem(Function<ProjectV2ItemSelector, R> selection);
}
