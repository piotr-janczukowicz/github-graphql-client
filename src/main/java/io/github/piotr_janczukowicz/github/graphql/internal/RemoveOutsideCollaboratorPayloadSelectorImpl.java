package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RemoveOutsideCollaboratorPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RemoveOutsideCollaboratorPayload}; used by the generated selection code only.
 */
final class RemoveOutsideCollaboratorPayloadSelectorImpl implements RemoveOutsideCollaboratorPayloadSelector {

    private final Cursor cursor;

    RemoveOutsideCollaboratorPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R removedUser(final Function<UserSelector, R> selection) {
        return cursor.object("removedUser", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
