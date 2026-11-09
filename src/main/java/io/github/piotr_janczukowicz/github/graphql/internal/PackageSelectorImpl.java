package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageStatisticsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageType;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Package}; used by the generated selection code only. */
final class PackageSelectorImpl implements PackageSelector {

    private static final String VERSION = "version";

    private final Cursor cursor;

    PackageSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R latestVersion(final Function<PackageVersionSelector, R> selection) {
        return cursor.object("latestVersion", child -> selection.apply(new PackageVersionSelectorImpl(child)));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public PackageType packageType() {
        return cursor.getRequired("packageType", ScalarType.enumeration(PackageType::fromWire, PackageType.DEBIAN));
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R statistics(final Function<PackageStatisticsSelector, R> selection) {
        return cursor.object("statistics", child -> selection.apply(new PackageStatisticsSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R version(final String version, final Function<PackageVersionSelector, R> selection) {
        requireNonNull(version, VERSION);
        return cursor.object(
                VERSION,
                child -> selection.apply(new PackageVersionSelectorImpl(child)),
                Argument.of(VERSION, "String!", version));
    }

    @Override
    public <R> Page<R> versions(
            final Paging paging,
            final PackageVersionsFilter arguments,
            final Function<PackageVersionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "versions",
                child -> selection.apply(new PackageVersionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "PackageVersionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> versions(final Paging paging, final Function<PackageVersionSelector, R> selection) {
        return versions(paging, PackageVersionsFilterBuilder.builder().build(), selection);
    }
}
