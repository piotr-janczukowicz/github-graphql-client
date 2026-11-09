package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldAddedEvent}. */
public interface IssueFieldAddedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    @Nullable String color();

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    <R> List<R> options(Function<IssueFieldTimelineOptionSelector, R> selection);

    @Nullable String value();
}
