package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2View}. */
public interface ProjectV2ViewSelector {

    <R> R configuration(Function<ProjectV2ViewConfigurationSelector, R> selection);

    Instant createdAt();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    <R> Page<R> fields(
            Paging paging,
            ProjectV2ViewFieldsFilter arguments,
            Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> fields(Paging paging, Function<ProjectV2FieldConfigurationSelector, R> selection);

    @Nullable String filter();

    @Nullable BigInteger fullDatabaseId();

    /**
     * @deprecated The `ProjectV2View#order_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#group_by_field` API. Check out the `ProjectV2View#group_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> groupBy(
            Paging paging, ProjectV2ViewGroupByFilter arguments, Function<ProjectV2FieldSelector, R> selection);

    /**
     * @deprecated The `ProjectV2View#order_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#group_by_field` API. Check out the `ProjectV2View#group_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> groupBy(Paging paging, Function<ProjectV2FieldSelector, R> selection);

    <R> Page<R> groupByFields(
            Paging paging,
            ProjectV2ViewGroupByFieldsFilter arguments,
            Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> groupByFields(Paging paging, Function<ProjectV2FieldConfigurationSelector, R> selection);

    String id();

    ProjectV2ViewLayout layout();

    String name();

    int number();

    <R> R project(Function<ProjectV2Selector, R> selection);

    /**
     * @deprecated The `ProjectV2View#sort_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#sort_by_fields` API. Check out the `ProjectV2View#sort_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> sortBy(Paging paging, Function<ProjectV2SortBySelector, R> selection);

    <R> Page<R> sortByFields(Paging paging, Function<ProjectV2SortByFieldSelector, R> selection);

    Instant updatedAt();

    /**
     * @deprecated The `ProjectV2View#vertical_group_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#vertical_group_by_fields` API. Check out the `ProjectV2View#vertical_group_by_fields` API as
     *     an example for the more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> verticalGroupBy(
            Paging paging, ProjectV2ViewVerticalGroupByFilter arguments, Function<ProjectV2FieldSelector, R> selection);

    /**
     * @deprecated The `ProjectV2View#vertical_group_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#vertical_group_by_fields` API. Check out the `ProjectV2View#vertical_group_by_fields` API as
     *     an example for the more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> verticalGroupBy(Paging paging, Function<ProjectV2FieldSelector, R> selection);

    <R> Page<R> verticalGroupByFields(
            Paging paging,
            ProjectV2ViewVerticalGroupByFieldsFilter arguments,
            Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> verticalGroupByFields(Paging paging, Function<ProjectV2FieldConfigurationSelector, R> selection);

    /**
     * @deprecated The `ProjectV2View#visibleFields` API is deprecated in favour of the more capable
     *     `ProjectV2View#fields` API. Check out the `ProjectV2View#fields` API as an example for the more capable
     *     alternative. Removal on 2023-01-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> visibleFields(
            Paging paging, ProjectV2ViewVisibleFieldsFilter arguments, Function<ProjectV2FieldSelector, R> selection);

    /**
     * @deprecated The `ProjectV2View#visibleFields` API is deprecated in favour of the more capable
     *     `ProjectV2View#fields` API. Check out the `ProjectV2View#fields` API as an example for the more capable
     *     alternative. Removal on 2023-01-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> visibleFields(Paging paging, Function<ProjectV2FieldSelector, R> selection);
}
