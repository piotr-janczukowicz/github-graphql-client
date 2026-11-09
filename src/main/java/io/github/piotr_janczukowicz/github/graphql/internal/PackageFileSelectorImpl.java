package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PackageFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PackageFile}; used by the generated selection code only. */
final class PackageFileSelectorImpl implements PackageFileSelector {

    private final Cursor cursor;

    PackageFileSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String md5() {
        return cursor.get("md5", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R packageVersion(final Function<PackageVersionSelector, R> selection) {
        return cursor.object("packageVersion", child -> selection.apply(new PackageVersionSelectorImpl(child)));
    }

    @Override
    public @Nullable String sha1() {
        return cursor.get("sha1", ScalarType.STRING);
    }

    @Override
    public @Nullable String sha256() {
        return cursor.get("sha256", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer size() {
        return cursor.get("size", ScalarType.INT);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String url() {
        return cursor.get("url", ScalarType.STRING);
    }
}
