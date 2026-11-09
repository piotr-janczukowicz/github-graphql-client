package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2ViewConfiguration}. */
public interface ProjectV2ViewConfigurationSelector {

    <R> Page<R> visibleFields(Paging paging, Function<ProjectV2FieldConfigurationSelector, R> selection);
}
