package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MergeQueue}. */
public interface MergeQueueSelector {

    <R> @Nullable R configuration(Function<MergeQueueConfigurationSelector, R> selection);

    <R> Page<R> entries(Paging paging, Function<MergeQueueEntrySelector, R> selection);

    String id();

    @Nullable Integer nextEntryEstimatedTimeToMerge();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    String url();
}
