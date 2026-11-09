package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2CollaboratorsPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateProjectV2CollaboratorsPayload}; used by the generated selection code
 * only.
 */
final class UpdateProjectV2CollaboratorsPayloadSelectorImpl implements UpdateProjectV2CollaboratorsPayloadSelector {

    private final Cursor cursor;

    UpdateProjectV2CollaboratorsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> collaborators(final Paging paging, final Function<ProjectV2ActorSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "collaborators",
                child -> selection.apply(new ProjectV2ActorSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
