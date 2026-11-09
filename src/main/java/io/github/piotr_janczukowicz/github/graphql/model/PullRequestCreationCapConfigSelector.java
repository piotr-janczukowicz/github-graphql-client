package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code PullRequestCreationCapConfig}. */
public interface PullRequestCreationCapConfigSelector {

    <R> Page<R> bypassedUsers(Paging paging, Function<UserSelector, R> selection);
}
