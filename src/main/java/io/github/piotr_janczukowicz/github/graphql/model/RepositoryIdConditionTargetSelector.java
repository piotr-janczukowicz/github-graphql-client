package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code RepositoryIdConditionTarget}. */
public interface RepositoryIdConditionTargetSelector {

    List<String> repositoryIds();
}
