package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code App}. */
public interface AppSelector {

    @Nullable String clientId();

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String description();

    String id();

    <R> Page<R> ipAllowListEntries(
            Paging paging, AppIpAllowListEntriesFilter arguments, Function<IpAllowListEntrySelector, R> selection);

    <R> Page<R> ipAllowListEntries(Paging paging, Function<IpAllowListEntrySelector, R> selection);

    String logoBackgroundColor();

    String logoUrl(AppLogoUrlFilter arguments);

    String logoUrl();

    String name();

    String slug();

    Instant updatedAt();

    String url();
}
