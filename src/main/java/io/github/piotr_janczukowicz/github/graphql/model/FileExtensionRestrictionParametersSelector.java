package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code FileExtensionRestrictionParameters}. */
public interface FileExtensionRestrictionParametersSelector {

    List<String> restrictedFileExtensions();
}
