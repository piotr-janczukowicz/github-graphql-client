package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code ProjectColumn.cards}; an argument left {@code null} is not sent. */
@RecordBuilder
public record ProjectColumnCardsFilter(@Nullable List<ProjectCardArchivedState> archivedStates) {

    public ProjectColumnCardsFilter {
        archivedStates = ListUtils.copyOrNull(archivedStates);
    }
}
