package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldChangedEvent}. */
public interface IssueFieldChangedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    @Nullable String newColor();

    <R> List<R> newOptions(Function<IssueFieldTimelineOptionSelector, R> selection);

    @Nullable String newValue();

    @Nullable String previousColor();

    <R> List<R> previousOptions(Function<IssueFieldTimelineOptionSelector, R> selection);

    @Nullable String previousValue();
}
