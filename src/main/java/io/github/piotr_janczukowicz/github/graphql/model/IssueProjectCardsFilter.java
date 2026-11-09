package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Issue.projectCards}; an argument left {@code null} is not sent. */
@RecordBuilder
public record IssueProjectCardsFilter(@Nullable List<ProjectCardArchivedState> archivedStates) {

    public IssueProjectCardsFilter {
        archivedStates = ListUtils.copyOrNull(archivedStates);
    }
}
