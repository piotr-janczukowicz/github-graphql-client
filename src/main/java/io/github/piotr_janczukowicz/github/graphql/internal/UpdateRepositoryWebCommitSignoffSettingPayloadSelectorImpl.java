package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateRepositoryWebCommitSignoffSettingPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateRepositoryWebCommitSignoffSettingPayload}; used by the generated
 * selection code only.
 */
final class UpdateRepositoryWebCommitSignoffSettingPayloadSelectorImpl
        implements UpdateRepositoryWebCommitSignoffSettingPayloadSelector {

    private final Cursor cursor;

    UpdateRepositoryWebCommitSignoffSettingPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
