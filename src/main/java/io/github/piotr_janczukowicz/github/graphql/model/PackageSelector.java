package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Package}. */
public interface PackageSelector {

    String id();

    <R> @Nullable R latestVersion(Function<PackageVersionSelector, R> selection);

    String name();

    PackageType packageType();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    <R> @Nullable R statistics(Function<PackageStatisticsSelector, R> selection);

    <R> @Nullable R version(String version, Function<PackageVersionSelector, R> selection);

    <R> Page<R> versions(Paging paging, PackageVersionsFilter arguments, Function<PackageVersionSelector, R> selection);

    <R> Page<R> versions(Paging paging, Function<PackageVersionSelector, R> selection);
}
