package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IssueFieldValuesSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2IssueFieldValues}; used by the generated selection code only. */
final class ProjectV2IssueFieldValuesSelectorImpl implements ProjectV2IssueFieldValuesSelector {

    private final Cursor cursor;

    ProjectV2IssueFieldValuesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ProjectV2IssueFieldValuesSelector.class, type, selection);
    }
}
