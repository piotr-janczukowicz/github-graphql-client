package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Repository.packages}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RepositoryPackagesFilter(
        @Nullable List<String> names,
        @Nullable PackageOrder orderBy,
        @Nullable PackageType packageType,
        @Nullable String repositoryId) {

    public RepositoryPackagesFilter {
        names = ListUtils.copyOrNull(names);
    }
}
