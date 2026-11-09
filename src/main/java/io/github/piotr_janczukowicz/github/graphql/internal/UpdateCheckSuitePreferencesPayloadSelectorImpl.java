package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateCheckSuitePreferencesPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateCheckSuitePreferencesPayload}; used by the generated selection code
 * only.
 */
final class UpdateCheckSuitePreferencesPayloadSelectorImpl implements UpdateCheckSuitePreferencesPayloadSelector {

    private final Cursor cursor;

    UpdateCheckSuitePreferencesPayloadSelectorImpl(final Cursor cursor) {
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
