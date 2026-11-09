package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code ProjectV2.items}; an argument left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2ItemsFilter(
        @Nullable List<ProjectV2ItemArchivedState> archivedStates,
        @Nullable ProjectV2ItemOrder orderBy,
        @Nullable String query) {

    public ProjectV2ItemsFilter {
        archivedStates = ListUtils.copyOrNull(archivedStates);
    }
}
