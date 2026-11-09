package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldSingleSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionColor;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ProjectV2ItemFieldSingleSelectValue}; used by the generated selection code
 * only.
 */
final class ProjectV2ItemFieldSingleSelectValueSelectorImpl implements ProjectV2ItemFieldSingleSelectValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldSingleSelectValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ProjectV2SingleSelectFieldOptionColor color() {
        return cursor.getRequired(
                "color",
                ScalarType.enumeration(
                        ProjectV2SingleSelectFieldOptionColor::fromWire, ProjectV2SingleSelectFieldOptionColor.BLUE));
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
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public @Nullable String descriptionHTML() {
        return cursor.get("descriptionHTML", ScalarType.STRING);
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
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String nameHTML() {
        return cursor.get("nameHTML", ScalarType.STRING);
    }

    @Override
    public @Nullable String optionId() {
        return cursor.get("optionId", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
