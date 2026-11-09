package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PackageVersion}. */
public interface PackageVersionSelector {

    <R> Page<R> files(Paging paging, PackageVersionFilesFilter arguments, Function<PackageFileSelector, R> selection);

    <R> Page<R> files(Paging paging, Function<PackageFileSelector, R> selection);

    String id();

    <R> @Nullable R packageValue(Function<PackageSelector, R> selection);

    @Nullable String platform();

    boolean preRelease();

    @Nullable String readme();

    <R> @Nullable R release(Function<ReleaseSelector, R> selection);

    <R> @Nullable R statistics(Function<PackageVersionStatisticsSelector, R> selection);

    @Nullable String summary();

    String version();
}
