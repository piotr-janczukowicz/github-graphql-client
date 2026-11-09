package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PropertyTargetDefinition}. */
public interface PropertyTargetDefinitionSelector {

    String name();

    List<String> propertyValues();

    @Nullable String source();
}
