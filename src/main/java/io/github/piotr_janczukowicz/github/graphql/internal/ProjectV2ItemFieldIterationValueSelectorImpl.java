package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldIterationValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ProjectV2ItemFieldIterationValue}; used by the generated selection code only.
 */
final class ProjectV2ItemFieldIterationValueSelectorImpl implements ProjectV2ItemFieldIterationValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldIterationValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public int duration() {
        return cursor.getRequired("duration", ScalarType.INT);
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R item(final Function<ProjectV2ItemSelector, R> selection) {
        return cursor.objectRequired("item", child -> selection.apply(new ProjectV2ItemSelectorImpl(child)));
    }

    @Override
    public String iterationId() {
        return cursor.getRequired("iterationId", ScalarType.STRING);
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

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
