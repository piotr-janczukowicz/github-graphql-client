package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldUserValue}. */
public interface ProjectV2ItemFieldUserValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> users(Paging paging, Function<UserSelector, R> selection);
}
