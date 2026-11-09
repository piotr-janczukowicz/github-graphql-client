package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateProjectV2IssueFieldPayload}. */
public interface CreateProjectV2IssueFieldPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectV2Field(Function<ProjectV2FieldConfigurationSelector, R> selection);
}
