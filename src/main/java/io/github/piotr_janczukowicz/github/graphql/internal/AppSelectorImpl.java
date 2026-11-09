package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AppIpAllowListEntriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.AppIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AppLogoUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.AppLogoUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code App}; used by the generated selection code only. */
final class AppSelectorImpl implements AppSelector {

    private final Cursor cursor;

    AppSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientId() {
        return cursor.get("clientId", ScalarType.STRING);
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
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> ipAllowListEntries(
            final Paging paging,
            final AppIpAllowListEntriesFilter arguments,
            final Function<IpAllowListEntrySelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "ipAllowListEntries",
                child -> selection.apply(new IpAllowListEntrySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "IpAllowListEntryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> ipAllowListEntries(final Paging paging, final Function<IpAllowListEntrySelector, R> selection) {
        return ipAllowListEntries(
                paging, AppIpAllowListEntriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String logoBackgroundColor() {
        return cursor.getRequired("logoBackgroundColor", ScalarType.STRING);
    }

    @Override
    public String logoUrl(final AppLogoUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired("logoUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String logoUrl() {
        return logoUrl(AppLogoUrlFilterBuilder.builder().build());
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String slug() {
        return cursor.getRequired("slug", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
