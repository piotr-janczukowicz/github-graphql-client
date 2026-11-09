package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code FilePathRestrictionParameters}. */
public interface FilePathRestrictionParametersSelector {

    List<String> ignoredFilePaths();

    List<String> restrictedFilePaths();
}
