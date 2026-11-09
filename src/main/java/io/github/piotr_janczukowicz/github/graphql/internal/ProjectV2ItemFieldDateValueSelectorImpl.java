package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2ItemFieldDateValue}; used by the generated selection code only. */
final class ProjectV2ItemFieldDateValueSelectorImpl implements ProjectV2ItemFieldDateValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldDateValueSelectorImpl(final Cursor cursor) {
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
    public @Nullable LocalDate date() {
        return cursor.get("date", ScalarType.LOCAL_DATE);
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
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
