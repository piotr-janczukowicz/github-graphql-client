package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PackageFile}. */
public interface PackageFileSelector {

    String id();

    @Nullable String md5();

    String name();

    <R> @Nullable R packageVersion(Function<PackageVersionSelector, R> selection);

    @Nullable String sha1();

    @Nullable String sha256();

    @Nullable Integer size();

    Instant updatedAt();

    @Nullable String url();
}
