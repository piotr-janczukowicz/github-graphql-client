package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;

/** Selection of the GraphQL type {@code Topic}. */
public interface TopicSelector {

    String id();

    String name();

    <R> List<R> relatedTopics(TopicRelatedTopicsFilter arguments, Function<TopicSelector, R> selection);

    <R> List<R> relatedTopics(Function<TopicSelector, R> selection);

    <R> Page<R> repositories(
            Paging paging, TopicRepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    int stargazerCount();

    <R> Page<R> stargazers(Paging paging, TopicStargazersFilter arguments, Function<UserSelector, R> selection);

    <R> Page<R> stargazers(Paging paging, Function<UserSelector, R> selection);

    boolean viewerHasStarred();
}
