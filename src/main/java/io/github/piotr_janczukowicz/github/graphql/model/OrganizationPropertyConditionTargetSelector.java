package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code OrganizationPropertyConditionTarget}. */
public interface OrganizationPropertyConditionTargetSelector {

    <R> List<R> exclude(Function<OrganizationPropertyTargetDefinitionSelector, R> selection);

    <R> List<R> include(Function<OrganizationPropertyTargetDefinitionSelector, R> selection);
}
