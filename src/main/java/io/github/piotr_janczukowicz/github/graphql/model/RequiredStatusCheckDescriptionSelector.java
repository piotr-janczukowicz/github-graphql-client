package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RequiredStatusCheckDescription}. */
public interface RequiredStatusCheckDescriptionSelector {

    <R> @Nullable R app(Function<AppSelector, R> selection);

    String context();
}
