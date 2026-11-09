package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphDependencySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DependencyGraphDependency}; used by the generated selection code only. */
final class DependencyGraphDependencySelectorImpl implements DependencyGraphDependencySelector {

    private final Cursor cursor;

    DependencyGraphDependencySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasDependencies() {
        return cursor.getRequired("hasDependencies", ScalarType.BOOLEAN);
    }

    /**
     * @deprecated `packageLabel` will be removed. Use normalized `packageName` field instead. Removal on 2022-10-01
     *     UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public String packageLabel() {
        return cursor.getRequired("packageLabel", ScalarType.STRING);
    }

    @Override
    public @Nullable String packageManager() {
        return cursor.get("packageManager", ScalarType.STRING);
    }

    @Override
    public String packageName() {
        return cursor.getRequired("packageName", ScalarType.STRING);
    }

    @Override
    public @Nullable String packageUrl() {
        return cursor.get("packageUrl", ScalarType.STRING);
    }

    @Override
    public String relationship() {
        return cursor.getRequired("relationship", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String requirements() {
        return cursor.getRequired("requirements", ScalarType.STRING);
    }
}
