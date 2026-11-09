package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddLabelsToLabelablePayload}. */
public interface AddLabelsToLabelablePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R labelable(Function<LabelableSelector, R> selection);
}
