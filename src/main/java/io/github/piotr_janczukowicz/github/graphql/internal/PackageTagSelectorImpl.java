package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PackageTagSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PackageTag}; used by the generated selection code only. */
final class PackageTagSelectorImpl implements PackageTagSelector {

    private final Cursor cursor;

    PackageTagSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R version(final Function<PackageVersionSelector, R> selection) {
        return cursor.object("version", child -> selection.apply(new PackageVersionSelectorImpl(child)));
    }
}
