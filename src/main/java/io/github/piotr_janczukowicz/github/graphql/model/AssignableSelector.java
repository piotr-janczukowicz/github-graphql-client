package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Assignable}. */
public interface AssignableSelector {

    <R> Page<R> assignedActors(Paging paging, Function<AssigneeSelector, R> selection);

    <R> Page<R> assignees(Paging paging, Function<UserSelector, R> selection);

    <R> Page<R> suggestedActors(
            Paging paging, AssignableSuggestedActorsFilter arguments, Function<AssigneeSelector, R> selection);

    <R> Page<R> suggestedActors(Paging paging, Function<AssigneeSelector, R> selection);

    boolean viewerCanAssign();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
