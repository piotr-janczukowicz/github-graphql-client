package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldRemovedEvent}. */
public interface IssueFieldRemovedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    <R> @Nullable R issueField(Function<IssueFieldsSelector, R> selection);

    <R> List<R> options(Function<IssueFieldTimelineOptionSelector, R> selection);
}
