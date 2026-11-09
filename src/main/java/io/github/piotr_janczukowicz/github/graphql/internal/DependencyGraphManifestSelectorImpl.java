package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphDependencySelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphManifestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DependencyGraphManifest}; used by the generated selection code only. */
final class DependencyGraphManifestSelectorImpl implements DependencyGraphManifestSelector {

    private final Cursor cursor;

    DependencyGraphManifestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String blobPath() {
        return cursor.getRequired("blobPath", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> dependencies(
            final Paging paging, final Function<DependencyGraphDependencySelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "dependencies",
                child -> selection.apply(new DependencyGraphDependencySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public @Nullable Integer dependenciesCount() {
        return cursor.get("dependenciesCount", ScalarType.INT);
    }

    @Override
    public boolean exceedsMaxSize() {
        return cursor.getRequired("exceedsMaxSize", ScalarType.BOOLEAN);
    }

    @Override
    public String filename() {
        return cursor.getRequired("filename", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean parseable() {
        return cursor.getRequired("parseable", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
