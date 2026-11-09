package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldType;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2SingleSelectField}; used by the generated selection code only. */
final class ProjectV2SingleSelectFieldSelectorImpl implements ProjectV2SingleSelectFieldSelector {

    private final Cursor cursor;

    ProjectV2SingleSelectFieldSelectorImpl(final Cursor cursor) {
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
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> List<R> options(
            final ProjectV2SingleSelectFieldOptionsFilter arguments,
            final Function<ProjectV2SingleSelectFieldOptionSelector, R> selection) {
        requireNonNull(arguments, "arguments");
        return cursor.listRequired(
                "options",
                child -> selection.apply(new ProjectV2SingleSelectFieldOptionSelectorImpl(child)),
                Argument.of("names", "[String!]", arguments.names()));
    }

    @Override
    public <R> List<R> options(final Function<ProjectV2SingleSelectFieldOptionSelector, R> selection) {
        return options(ProjectV2SingleSelectFieldOptionsFilterBuilder.builder().build(), selection);
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
