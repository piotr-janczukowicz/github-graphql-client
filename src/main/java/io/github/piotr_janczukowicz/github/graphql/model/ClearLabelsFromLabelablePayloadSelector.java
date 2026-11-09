package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ClearLabelsFromLabelablePayload}. */
public interface ClearLabelsFromLabelablePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R labelable(Function<LabelableSelector, R> selection);
}
