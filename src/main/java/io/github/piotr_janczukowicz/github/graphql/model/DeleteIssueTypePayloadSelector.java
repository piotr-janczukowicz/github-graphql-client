package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeleteIssueTypePayload}. */
public interface DeleteIssueTypePayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String deletedIssueTypeId();
}
