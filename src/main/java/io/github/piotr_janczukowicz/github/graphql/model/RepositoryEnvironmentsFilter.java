package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Repository.environments}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RepositoryEnvironmentsFilter(
        @Nullable List<String> names,
        @Nullable Environments orderBy,
        @Nullable EnvironmentPinnedFilterField pinnedEnvironmentFilter) {

    public RepositoryEnvironmentsFilter {
        names = ListUtils.copyOrNull(names);
    }
}
