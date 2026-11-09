package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateProjectV2IssueFieldPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreateProjectV2IssueFieldPayload}; used by the generated selection code only.
 */
final class CreateProjectV2IssueFieldPayloadSelectorImpl implements CreateProjectV2IssueFieldPayloadSelector {

    private final Cursor cursor;

    CreateProjectV2IssueFieldPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R projectV2Field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.object(
                "projectV2Field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }
}
