package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Submodule}. */
public interface SubmoduleSelector {

    @Nullable String branch();

    String gitUrl();

    String name();

    String nameRaw();

    String path();

    String pathRaw();

    @Nullable String subprojectCommitOid();
}
