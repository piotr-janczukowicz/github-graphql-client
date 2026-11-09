package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldMultiSelectOptionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldMultiSelectOptionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2MultiSelectField}; used by the generated selection code only. */
final class ProjectV2MultiSelectFieldSelectorImpl implements ProjectV2MultiSelectFieldSelector {

    private final Cursor cursor;

    ProjectV2MultiSelectFieldSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public <R> @Nullable R issueField(final Function<IssueFieldsSelector, R> selection) {
        return cursor.object("issueField", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }

    @Override
    public <R> List<R> multiSelectOptions(
            final ProjectV2MultiSelectFieldMultiSelectOptionsFilter arguments,
            final Function<ProjectV2MultiSelectFieldOptionSelector, R> selection) {
        requireNonNull(arguments, "arguments");
        return cursor.listRequired(
                "multiSelectOptions",
                child -> selection.apply(new ProjectV2MultiSelectFieldOptionSelectorImpl(child)),
                Argument.of("names", "[String!]", arguments.names()));
    }

    @Override
    public <R> List<R> multiSelectOptions(final Function<ProjectV2MultiSelectFieldOptionSelector, R> selection) {
        return multiSelectOptions(
                ProjectV2MultiSelectFieldMultiSelectOptionsFilterBuilder.builder()
                        .build(),
                selection);
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
