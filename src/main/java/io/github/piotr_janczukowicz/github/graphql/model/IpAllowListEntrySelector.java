package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IpAllowListEntry}. */
public interface IpAllowListEntrySelector {

    String allowListValue();

    Instant createdAt();

    String id();

    boolean isActive();

    @Nullable String name();

    <R> R owner(Function<IpAllowListOwnerSelector, R> selection);

    Instant updatedAt();
}
