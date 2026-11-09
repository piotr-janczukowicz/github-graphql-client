package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SetRepositoryCustomPropertyValuesPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code SetRepositoryCustomPropertyValuesPayload}; used by the generated selection
 * code only.
 */
final class SetRepositoryCustomPropertyValuesPayloadSelectorImpl
        implements SetRepositoryCustomPropertyValuesPayloadSelector {

    private final Cursor cursor;

    SetRepositoryCustomPropertyValuesPayloadSelectorImpl(final Cursor cursor) {
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
