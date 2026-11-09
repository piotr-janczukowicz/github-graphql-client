package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnlinkProjectV2FromTeamPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UnlinkProjectV2FromTeamPayload}; used by the generated selection code only.
 */
final class UnlinkProjectV2FromTeamPayloadSelectorImpl implements UnlinkProjectV2FromTeamPayloadSelector {

    private final Cursor cursor;

    UnlinkProjectV2FromTeamPayloadSelectorImpl(final Cursor cursor) {
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
