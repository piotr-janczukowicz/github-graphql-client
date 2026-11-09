package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldIterationSelector;
import java.time.LocalDate;

/**
 * Reads and records the fields of {@code ProjectV2IterationFieldIteration}; used by the generated selection code only.
 */
final class ProjectV2IterationFieldIterationSelectorImpl implements ProjectV2IterationFieldIterationSelector {

    private final Cursor cursor;

    ProjectV2IterationFieldIterationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int duration() {
        return cursor.getRequired("duration", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public LocalDate startDate() {
        return cursor.getRequired("startDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public String titleHTML() {
        return cursor.getRequired("titleHTML", ScalarType.STRING);
    }
}
