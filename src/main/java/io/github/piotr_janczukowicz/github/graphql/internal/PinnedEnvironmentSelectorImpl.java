package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedEnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinnedEnvironment}; used by the generated selection code only. */
final class PinnedEnvironmentSelectorImpl implements PinnedEnvironmentSelector {

    private final Cursor cursor;

    PinnedEnvironmentSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> R environment(final Function<EnvironmentSelector, R> selection) {
        return cursor.objectRequired("environment", child -> selection.apply(new EnvironmentSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public int position() {
        return cursor.getRequired("position", ScalarType.INT);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
