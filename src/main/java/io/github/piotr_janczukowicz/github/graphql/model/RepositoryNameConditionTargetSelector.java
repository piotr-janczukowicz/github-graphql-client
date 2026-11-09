package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code RepositoryNameConditionTarget}. */
public interface RepositoryNameConditionTargetSelector {

    List<String> exclude();

    List<String> include();

    boolean protectedValue();
}
