package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2OwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2RepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2RepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdatesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2StatusUpdatesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2TeamsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2TeamsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ViewsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2WorkflowsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ProjectV2}; used by the generated selection code only. */
final class ProjectV2SelectorImpl implements ProjectV2Selector {

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ORDER_BY = "orderBy";

    private static final String NUMBER = "number";

    private final Cursor cursor;

    ProjectV2SelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R field(final String name, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(name, "name");
        return cursor.object(
                "field",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of("name", "String!", name));
    }

    @Override
    public <R> Page<R> fields(
            final Paging paging,
            final ProjectV2FieldsFilter arguments,
            final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "fields",
                child -> selection.apply(new ProjectV2FieldConfigurationSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2FieldOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> fields(final Paging paging, final Function<ProjectV2FieldConfigurationSelector, R> selection) {
        return fields(paging, ProjectV2FieldsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> items(
            final Paging paging,
            final ProjectV2ItemsFilter arguments,
            final Function<ProjectV2ItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "items",
                child -> selection.apply(new ProjectV2ItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("archivedStates", "[ProjectV2ItemArchivedState!]", arguments.archivedStates()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2ItemOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> items(final Paging paging, final Function<ProjectV2ItemSelector, R> selection) {
        return items(paging, ProjectV2ItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public int number() {
        return cursor.getRequired(NUMBER, ScalarType.INT);
    }

    @Override
    public <R> R owner(final Function<ProjectV2OwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new ProjectV2OwnerSelectorImpl(child)));
    }

    @Override
    public boolean publicValue() {
        return cursor.getRequired("public", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String readme() {
        return cursor.get("readme", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final ProjectV2RepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(paging, ProjectV2RepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String shortDescription() {
        return cursor.get("shortDescription", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> statusUpdates(
            final Paging paging,
            final ProjectV2StatusUpdatesFilter arguments,
            final Function<ProjectV2StatusUpdateSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "statusUpdates",
                child -> selection.apply(new ProjectV2StatusUpdateSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2StatusOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> statusUpdates(final Paging paging, final Function<ProjectV2StatusUpdateSelector, R> selection) {
        return statusUpdates(
                paging, ProjectV2StatusUpdatesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> teams(
            final Paging paging, final ProjectV2TeamsFilter arguments, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "teams",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "TeamOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> teams(final Paging paging, final Function<TeamSelector, R> selection) {
        return teams(paging, ProjectV2TeamsFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean template() {
        return cursor.getRequired("template", ScalarType.BOOLEAN);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R view(final int number, final Function<ProjectV2ViewSelector, R> selection) {
        return cursor.object(
                "view",
                child -> selection.apply(new ProjectV2ViewSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdate() {
        return cursor.getRequired("viewerCanUpdate", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> views(
            final Paging paging,
            final ProjectV2ViewsFilter arguments,
            final Function<ProjectV2ViewSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "views",
                child -> selection.apply(new ProjectV2ViewSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2ViewOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> views(final Paging paging, final Function<ProjectV2ViewSelector, R> selection) {
        return views(paging, ProjectV2ViewsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R workflow(final int number, final Function<ProjectV2WorkflowSelector, R> selection) {
        return cursor.object(
                "workflow",
                child -> selection.apply(new ProjectV2WorkflowSelectorImpl(child)),
                Argument.of(NUMBER, INT, number));
    }

    @Override
    public <R> Page<R> workflows(
            final Paging paging,
            final ProjectV2WorkflowsFilter arguments,
            final Function<ProjectV2WorkflowSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "workflows",
                child -> selection.apply(new ProjectV2WorkflowSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2WorkflowOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> workflows(final Paging paging, final Function<ProjectV2WorkflowSelector, R> selection) {
        return workflows(paging, ProjectV2WorkflowsFilterBuilder.builder().build(), selection);
    }
}
