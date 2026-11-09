package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RemovePullRequestCreationCapBypassUsersPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RemovePullRequestCreationCapBypassUsersPayload}; used by the generated
 * selection code only.
 */
final class RemovePullRequestCreationCapBypassUsersPayloadSelectorImpl
        implements RemovePullRequestCreationCapBypassUsersPayloadSelector {

    private final Cursor cursor;

    RemovePullRequestCreationCapBypassUsersPayloadSelectorImpl(final Cursor cursor) {
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
}
