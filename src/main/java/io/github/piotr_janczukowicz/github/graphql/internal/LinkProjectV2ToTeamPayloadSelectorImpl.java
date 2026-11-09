package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LinkProjectV2ToTeamPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code LinkProjectV2ToTeamPayload}; used by the generated selection code only. */
final class LinkProjectV2ToTeamPayloadSelectorImpl implements LinkProjectV2ToTeamPayloadSelector {

    private final Cursor cursor;

    LinkProjectV2ToTeamPayloadSelectorImpl(final Cursor cursor) {
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
