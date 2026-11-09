package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;

/** Selection of the GraphQL type {@code RepositoryTopic}. */
public interface RepositoryTopicSelector {

    String id();

    String resourcePath();

    <R> R topic(Function<TopicSelector, R> selection);

    String url();
}
