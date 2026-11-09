package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DraftIssue}. */
public interface DraftIssueSelector {

    <R> Page<R> assignees(Paging paging, Function<UserSelector, R> selection);

    String body();

    String bodyHTML();

    String bodyText();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    String id();

    <R> Page<R> projectV2Items(Paging paging, Function<ProjectV2ItemSelector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    String title();

    Instant updatedAt();
}
