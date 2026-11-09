package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateTeamsRepositoryPayloadSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateTeamsRepositoryPayload}; used by the generated selection code only. */
final class UpdateTeamsRepositoryPayloadSelectorImpl implements UpdateTeamsRepositoryPayloadSelector {

    private final Cursor cursor;

    UpdateTeamsRepositoryPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> List<R> teams(final Function<TeamSelector, R> selection) {
        return cursor.list("teams", child -> selection.apply(new TeamSelectorImpl(child)));
    }
}
