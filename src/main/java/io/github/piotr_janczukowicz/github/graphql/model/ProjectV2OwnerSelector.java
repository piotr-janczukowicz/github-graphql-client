package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2Owner}. */
public interface ProjectV2OwnerSelector {

    String id();

    <R> @Nullable R projectV2(int number, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(
            Paging paging, ProjectV2OwnerProjectsV2Filter arguments, Function<ProjectV2Selector, R> selection);

    <R> Page<R> projectsV2(Paging paging, Function<ProjectV2Selector, R> selection);

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
