package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PackageFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionFilesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionFilesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionStatisticsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PackageVersion}; used by the generated selection code only. */
final class PackageVersionSelectorImpl implements PackageVersionSelector {

    private final Cursor cursor;

    PackageVersionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> files(
            final Paging paging,
            final PackageVersionFilesFilter arguments,
            final Function<PackageFileSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "files",
                child -> selection.apply(new PackageFileSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "PackageFileOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> files(final Paging paging, final Function<PackageFileSelector, R> selection) {
        return files(paging, PackageVersionFilesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R packageValue(final Function<PackageSelector, R> selection) {
        return cursor.object("package", child -> selection.apply(new PackageSelectorImpl(child)));
    }

    @Override
    public @Nullable String platform() {
        return cursor.get("platform", ScalarType.STRING);
    }

    @Override
    public boolean preRelease() {
        return cursor.getRequired("preRelease", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String readme() {
        return cursor.get("readme", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R release(final Function<ReleaseSelector, R> selection) {
        return cursor.object("release", child -> selection.apply(new ReleaseSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R statistics(final Function<PackageVersionStatisticsSelector, R> selection) {
        return cursor.object("statistics", child -> selection.apply(new PackageVersionStatisticsSelectorImpl(child)));
    }

    @Override
    public @Nullable String summary() {
        return cursor.get("summary", ScalarType.STRING);
    }

    @Override
    public String version() {
        return cursor.getRequired("version", ScalarType.STRING);
    }
}
