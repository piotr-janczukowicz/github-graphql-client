package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateProjectV2DraftIssuePayload}. */
public interface UpdateProjectV2DraftIssuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R draftIssue(Function<DraftIssueSelector, R> selection);
}
