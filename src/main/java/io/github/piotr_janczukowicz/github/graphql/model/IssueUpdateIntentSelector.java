package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueUpdateIntent}. */
public interface IssueUpdateIntentSelector {

    @Nullable IssueEventConfidenceLevel confidence();

    @Nullable Integer databaseId();

    @Nullable String intentId();

    @Nullable String rationale();
}
