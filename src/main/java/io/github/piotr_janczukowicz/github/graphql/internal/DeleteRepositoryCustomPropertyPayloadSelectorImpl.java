package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeleteRepositoryCustomPropertyPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeleteRepositoryCustomPropertyPayload}; used by the generated selection code
 * only.
 */
final class DeleteRepositoryCustomPropertyPayloadSelectorImpl implements DeleteRepositoryCustomPropertyPayloadSelector {

    private final Cursor cursor;

    DeleteRepositoryCustomPropertyPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repositoryCustomProperty(final Function<RepositoryCustomPropertySelector, R> selection) {
        return cursor.object(
                "repositoryCustomProperty", child -> selection.apply(new RepositoryCustomPropertySelectorImpl(child)));
    }
}
