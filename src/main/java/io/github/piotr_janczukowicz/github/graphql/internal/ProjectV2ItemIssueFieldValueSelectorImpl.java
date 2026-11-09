package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2IssueFieldValuesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemIssueFieldValueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2ItemIssueFieldValue}; used by the generated selection code only. */
final class ProjectV2ItemIssueFieldValueSelectorImpl implements ProjectV2ItemIssueFieldValueSelector {

    private final Cursor cursor;

    ProjectV2ItemIssueFieldValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R issueFieldValue(final Function<ProjectV2IssueFieldValuesSelector, R> selection) {
        return cursor.object(
                "issueFieldValue", child -> selection.apply(new ProjectV2IssueFieldValuesSelectorImpl(child)));
    }
}
