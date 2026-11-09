package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code RepositoryPropertyConditionTarget}. */
public interface RepositoryPropertyConditionTargetSelector {

    <R> List<R> exclude(Function<PropertyTargetDefinitionSelector, R> selection);

    <R> List<R> include(Function<PropertyTargetDefinitionSelector, R> selection);
}
