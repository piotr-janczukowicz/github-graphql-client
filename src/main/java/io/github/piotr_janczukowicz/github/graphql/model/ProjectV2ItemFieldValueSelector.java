package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldValue}. */
public interface ProjectV2ItemFieldValueSelector {

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
