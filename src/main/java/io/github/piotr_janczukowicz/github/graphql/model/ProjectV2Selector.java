package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2}. */
public interface ProjectV2Selector {

    boolean closed();

    @Nullable Instant closedAt();

    Instant createdAt();

    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    <R> @Nullable R field(String name, Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> fields(
            Paging paging, ProjectV2FieldsFilter arguments, Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> fields(Paging paging, Function<ProjectV2FieldConfigurationSelector, R> selection);

    @Nullable BigInteger fullDatabaseId();

    String id();

    <R> Page<R> items(Paging paging, ProjectV2ItemsFilter arguments, Function<ProjectV2ItemSelector, R> selection);

    <R> Page<R> items(Paging paging, Function<ProjectV2ItemSelector, R> selection);

    int number();

    <R> R owner(Function<ProjectV2OwnerSelector, R> selection);

    boolean publicValue();

    @Nullable String readme();

    <R> Page<R> repositories(
            Paging paging, ProjectV2RepositoriesFilter arguments, Function<RepositorySelector, R> selection);

    <R> Page<R> repositories(Paging paging, Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable String shortDescription();

    <R> Page<R> statusUpdates(
            Paging paging,
            ProjectV2StatusUpdatesFilter arguments,
            Function<ProjectV2StatusUpdateSelector, R> selection);

    <R> Page<R> statusUpdates(Paging paging, Function<ProjectV2StatusUpdateSelector, R> selection);

    <R> Page<R> teams(Paging paging, ProjectV2TeamsFilter arguments, Function<TeamSelector, R> selection);

    <R> Page<R> teams(Paging paging, Function<TeamSelector, R> selection);

    boolean template();

    String title();

    Instant updatedAt();

    String url();

    <R> @Nullable R view(int number, Function<ProjectV2ViewSelector, R> selection);

    boolean viewerCanClose();

    boolean viewerCanReopen();

    boolean viewerCanUpdate();

    <R> Page<R> views(Paging paging, ProjectV2ViewsFilter arguments, Function<ProjectV2ViewSelector, R> selection);

    <R> Page<R> views(Paging paging, Function<ProjectV2ViewSelector, R> selection);

    <R> @Nullable R workflow(int number, Function<ProjectV2WorkflowSelector, R> selection);

    <R> Page<R> workflows(
            Paging paging, ProjectV2WorkflowsFilter arguments, Function<ProjectV2WorkflowSelector, R> selection);

    <R> Page<R> workflows(Paging paging, Function<ProjectV2WorkflowSelector, R> selection);
}
