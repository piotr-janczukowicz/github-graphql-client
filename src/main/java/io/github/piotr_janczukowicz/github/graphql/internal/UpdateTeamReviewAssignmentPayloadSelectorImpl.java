package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateTeamReviewAssignmentPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateTeamReviewAssignmentPayload}; used by the generated selection code only.
 */
final class UpdateTeamReviewAssignmentPayloadSelectorImpl implements UpdateTeamReviewAssignmentPayloadSelector {

    private final Cursor cursor;

    UpdateTeamReviewAssignmentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R team(final Function<TeamSelector, R> selection) {
        return cursor.object("team", child -> selection.apply(new TeamSelectorImpl(child)));
    }
}
