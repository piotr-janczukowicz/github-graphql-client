package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AssignedEvent}. */
public interface AssignedEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    <R> R assignable(Function<AssignableSelector, R> selection);

    <R> @Nullable R assignee(Function<AssigneeSelector, R> selection);

    Instant createdAt();

    String id();

    <R> @Nullable R intent(Function<IssueUpdateIntentSelector, R> selection);

    /** @deprecated Assignees can now be mannequins. Use the `assignee` field instead. Removal on 2020-01-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R user(Function<UserSelector, R> selection);
}
