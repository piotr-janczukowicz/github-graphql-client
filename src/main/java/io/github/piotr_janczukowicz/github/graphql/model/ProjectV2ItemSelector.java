package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2Item}. */
public interface ProjectV2ItemSelector {

    <R> @Nullable R content(Function<ProjectV2ItemContentSelector, R> selection);

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    <R> @Nullable R fieldValueByName(String name, Function<ProjectV2ItemFieldValueSelector, R> selection);

    <R> Page<R> fieldValues(
            Paging paging,
            ProjectV2ItemFieldValuesFilter arguments,
            Function<ProjectV2ItemFieldValueSelector, R> selection);

    <R> Page<R> fieldValues(Paging paging, Function<ProjectV2ItemFieldValueSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    boolean isArchived();

    <R> R project(Function<ProjectV2Selector, R> selection);

    ProjectV2ItemType type();

    Instant updatedAt();
}
