package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IterationFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2IterationField}; used by the generated selection code only. */
final class ProjectV2IterationFieldSelectorImpl implements ProjectV2IterationFieldSelector {

    private final Cursor cursor;

    ProjectV2IterationFieldSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R configuration(final Function<ProjectV2IterationFieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "configuration", child -> selection.apply(new ProjectV2IterationFieldConfigurationSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public ProjectV2FieldType dataType() {
        return cursor.getRequired(
                "dataType", ScalarType.enumeration(ProjectV2FieldType::fromWire, ProjectV2FieldType.ASSIGNEES));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isIssueField() {
        return cursor.getRequired("isIssueField", ScalarType.BOOLEAN);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.objectRequired("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
