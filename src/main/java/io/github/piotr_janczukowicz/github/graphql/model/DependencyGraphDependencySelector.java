package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DependencyGraphDependency}. */
public interface DependencyGraphDependencySelector {

    boolean hasDependencies();

    /**
     * @deprecated `packageLabel` will be removed. Use normalized `packageName` field instead. Removal on 2022-10-01
     *     UTC.
     */
    @Deprecated(forRemoval = true)
    String packageLabel();

    @Nullable String packageManager();

    String packageName();

    @Nullable String packageUrl();

    String relationship();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    String requirements();
}
