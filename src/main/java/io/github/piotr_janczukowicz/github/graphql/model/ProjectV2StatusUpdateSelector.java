package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2StatusUpdate}. */
public interface ProjectV2StatusUpdateSelector {

    @Nullable String body();

    @Nullable String bodyHTML();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    @Nullable BigInteger fullDatabaseId();

    String id();

    <R> R project(Function<ProjectV2Selector, R> selection);

    @Nullable LocalDate startDate();

    @Nullable ProjectV2StatusUpdateStatus status();

    @Nullable LocalDate targetDate();

    Instant updatedAt();
}
