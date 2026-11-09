package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ConvertProjectCardNoteToIssuePayload}. */
public interface ConvertProjectCardNoteToIssuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R projectCard(Function<ProjectCardSelector, R> selection);
}
