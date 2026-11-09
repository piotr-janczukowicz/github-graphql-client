package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentState;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Deployment}; used by the generated selection code only. */
final class DeploymentSelectorImpl implements DeploymentSelector {

    private final Cursor cursor;

    DeploymentSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R commit(final Function<CommitSelector, R> selection) {
        return cursor.object("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public String commitOid() {
        return cursor.getRequired("commitOid", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R creator(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("creator", child -> selection.apply(new ActorSelectorImpl(child)));
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
    public @Nullable String environment() {
        return cursor.get("environment", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String latestEnvironment() {
        return cursor.get("latestEnvironment", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R latestStatus(final Function<DeploymentStatusSelector, R> selection) {
        return cursor.object("latestStatus", child -> selection.apply(new DeploymentStatusSelectorImpl(child)));
    }

    @Override
    public @Nullable String originalEnvironment() {
        return cursor.get("originalEnvironment", ScalarType.STRING);
    }

    @Override
    public @Nullable String payload() {
        return cursor.get("payload", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ref(final Function<RefSelector, R> selection) {
        return cursor.object("ref", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public @Nullable DeploymentState state() {
        return cursor.get("state", ScalarType.enumeration(DeploymentState::fromWire, DeploymentState.ABANDONED));
    }

    @Override
    public <R> Page<R> statuses(final Paging paging, final Function<DeploymentStatusSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "statuses",
                child -> selection.apply(new DeploymentStatusSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public @Nullable String task() {
        return cursor.get("task", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
