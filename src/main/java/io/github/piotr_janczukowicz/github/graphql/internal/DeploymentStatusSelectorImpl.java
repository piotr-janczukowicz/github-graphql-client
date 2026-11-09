package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusState;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeploymentStatus}; used by the generated selection code only. */
final class DeploymentStatusSelectorImpl implements DeploymentStatusSelector {

    private final Cursor cursor;

    DeploymentStatusSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public <R> R deployment(final Function<DeploymentSelector, R> selection) {
        return cursor.objectRequired("deployment", child -> selection.apply(new DeploymentSelectorImpl(child)));
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
    public @Nullable String environmentUrl() {
        return cursor.get("environmentUrl", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String logUrl() {
        return cursor.get("logUrl", ScalarType.STRING);
    }

    @Override
    public DeploymentStatusState state() {
        return cursor.getRequired(
                "state", ScalarType.enumeration(DeploymentStatusState::fromWire, DeploymentStatusState.ERROR));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
