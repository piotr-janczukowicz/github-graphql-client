package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldTimelineOption}. */
public interface IssueFieldTimelineOptionSelector {

    @Nullable String color();

    String name();
}
