package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2Workflow}. */
public interface ProjectV2WorkflowSelector {

    Instant createdAt();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    boolean enabled();

    @Nullable BigInteger fullDatabaseId();

    String id();

    String name();

    int number();

    <R> R project(Function<ProjectV2Selector, R> selection);

    Instant updatedAt();
}
