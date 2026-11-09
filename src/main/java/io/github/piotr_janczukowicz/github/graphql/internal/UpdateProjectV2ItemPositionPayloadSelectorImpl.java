package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2ItemPositionPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateProjectV2ItemPositionPayload}; used by the generated selection code
 * only.
 */
final class UpdateProjectV2ItemPositionPayloadSelectorImpl implements UpdateProjectV2ItemPositionPayloadSelector {

    private final Cursor cursor;

    UpdateProjectV2ItemPositionPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> items(final Paging paging, final Function<ProjectV2ItemSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "items",
                child -> selection.apply(new ProjectV2ItemSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
