package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortByFieldSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SortBySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewGroupByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewLayout;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVerticalGroupByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVisibleFieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewVisibleFieldsFilterBuilder;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2View}; used by the generated selection code only. */
final class ProjectV2ViewSelectorImpl implements ProjectV2ViewSelector {

    private static final String REMOVAL = "removal";

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ORDER_BY = "orderBy";

    private static final String PROJECT_V2_FIELD_ORDER = "ProjectV2FieldOrder";

    private final Cursor cursor;

    ProjectV2ViewSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R configuration(final Function<ProjectV2ViewConfigurationSelector, R> selection) {
        return cursor.objectRequired(
                "configuration", child -> selection.apply(new ProjectV2ViewConfigurationSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> Page<R> fields(
            final Paging paging,
            final ProjectV2ViewFieldsFilter arguments,
            final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "fields",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> fields(final Paging paging, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return fields(paging, ProjectV2ViewFieldsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String filter() {
        return cursor.get("filter", ScalarType.STRING);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    /**
     * @deprecated The `ProjectV2View#order_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#group_by_field` API. Check out the `ProjectV2View#group_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> groupBy(
            final Paging paging,
            final ProjectV2ViewGroupByFilter arguments,
            final Function<ProjectV2FieldSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "groupBy",
                child -> selection.apply(new ProjectV2FieldSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    /**
     * @deprecated The `ProjectV2View#order_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#group_by_field` API. Check out the `ProjectV2View#group_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> groupBy(final Paging paging, final Function<ProjectV2FieldSelector, R> selection) {
        return groupBy(paging, ProjectV2ViewGroupByFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> groupByFields(
            final Paging paging,
            final ProjectV2ViewGroupByFieldsFilter arguments,
            final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "groupByFields",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> groupByFields(
            final Paging paging, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return groupByFields(
                paging, ProjectV2ViewGroupByFieldsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public ProjectV2ViewLayout layout() {
        return cursor.getRequired(
                "layout", ScalarType.enumeration(ProjectV2ViewLayout::fromWire, ProjectV2ViewLayout.BOARD_LAYOUT));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public <R> R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.objectRequired("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    /**
     * @deprecated The `ProjectV2View#sort_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#sort_by_fields` API. Check out the `ProjectV2View#sort_by_fields` API as an example for the
     *     more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> sortBy(final Paging paging, final Function<ProjectV2SortBySelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "sortBy",
                child -> selection.apply(new ProjectV2SortBySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> sortByFields(final Paging paging, final Function<ProjectV2SortByFieldSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "sortByFields",
                child -> selection.apply(new ProjectV2SortByFieldSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    /**
     * @deprecated The `ProjectV2View#vertical_group_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#vertical_group_by_fields` API. Check out the `ProjectV2View#vertical_group_by_fields` API as
     *     an example for the more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> verticalGroupBy(
            final Paging paging,
            final ProjectV2ViewVerticalGroupByFilter arguments,
            final Function<ProjectV2FieldSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "verticalGroupBy",
                child -> selection.apply(new ProjectV2FieldSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    /**
     * @deprecated The `ProjectV2View#vertical_group_by` API is deprecated in favour of the more capable
     *     `ProjectV2View#vertical_group_by_fields` API. Check out the `ProjectV2View#vertical_group_by_fields` API as
     *     an example for the more capable alternative. Removal on 2023-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> verticalGroupBy(final Paging paging, final Function<ProjectV2FieldSelector, R> selection) {
        return verticalGroupBy(
                paging, ProjectV2ViewVerticalGroupByFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> verticalGroupByFields(
            final Paging paging,
            final ProjectV2ViewVerticalGroupByFieldsFilter arguments,
            final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "verticalGroupByFields",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> verticalGroupByFields(
            final Paging paging, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return verticalGroupByFields(
                paging,
                ProjectV2ViewVerticalGroupByFieldsFilterBuilder.builder().build(),
                selection);
    }

    /**
     * @deprecated The `ProjectV2View#visibleFields` API is deprecated in favour of the more capable
     *     `ProjectV2View#fields` API. Check out the `ProjectV2View#fields` API as an example for the more capable
     *     alternative. Removal on 2023-01-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> visibleFields(
            final Paging paging,
            final ProjectV2ViewVisibleFieldsFilter arguments,
            final Function<ProjectV2FieldSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "visibleFields",
                child -> selection.apply(new ProjectV2FieldSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        PROJECT_V2_FIELD_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    /**
     * @deprecated The `ProjectV2View#visibleFields` API is deprecated in favour of the more capable
     *     `ProjectV2View#fields` API. Check out the `ProjectV2View#fields` API as an example for the more capable
     *     alternative. Removal on 2023-01-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> visibleFields(final Paging paging, final Function<ProjectV2FieldSelector, R> selection) {
        return visibleFields(
                paging, ProjectV2ViewVisibleFieldsFilterBuilder.builder().build(), selection);
    }
}
