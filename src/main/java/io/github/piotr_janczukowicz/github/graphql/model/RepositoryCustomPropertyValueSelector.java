package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;

/** Selection of the GraphQL type {@code RepositoryCustomPropertyValue}. */
public interface RepositoryCustomPropertyValueSelector {

    String propertyName();

    CustomPropertyValue value();
}
