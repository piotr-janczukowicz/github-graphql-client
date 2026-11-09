package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemFieldMilestoneValueSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ProjectV2ItemFieldMilestoneValue}; used by the generated selection code only.
 */
final class ProjectV2ItemFieldMilestoneValueSelectorImpl implements ProjectV2ItemFieldMilestoneValueSelector {

    private final Cursor cursor;

    ProjectV2ItemFieldMilestoneValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R field(final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "field", child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R milestone(final Function<MilestoneSelector, R> selection) {
        return cursor.object("milestone", child -> selection.apply(new MilestoneSelectorImpl(child)));
    }
}
