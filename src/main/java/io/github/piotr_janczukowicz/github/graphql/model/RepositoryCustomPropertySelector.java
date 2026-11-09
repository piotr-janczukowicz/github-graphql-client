package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryCustomProperty}. */
public interface RepositoryCustomPropertySelector {

    List<String> allowedValues();

    @Nullable CustomPropertyValue defaultValue();

    @Nullable String description();

    String id();

    String propertyName();

    @Nullable String regex();

    @Nullable Boolean requireExplicitValues();

    @Nullable Boolean required();

    <R> R source(Function<CustomPropertySourceSelector, R> selection);

    CustomPropertyValueType valueType();

    RepositoryCustomPropertyValuesEditableBy valuesEditableBy();
}
