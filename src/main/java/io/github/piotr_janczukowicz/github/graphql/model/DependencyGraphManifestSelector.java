package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DependencyGraphManifest}. */
public interface DependencyGraphManifestSelector {

    String blobPath();

    <R> Page<R> dependencies(Paging paging, Function<DependencyGraphDependencySelector, R> selection);

    @Nullable Integer dependenciesCount();

    boolean exceedsMaxSize();

    String filename();

    String id();

    boolean parseable();

    <R> R repository(Function<RepositorySelector, R> selection);
}
