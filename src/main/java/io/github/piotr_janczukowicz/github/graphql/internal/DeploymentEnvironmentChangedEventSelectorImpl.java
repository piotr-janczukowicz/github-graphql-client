package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentEnvironmentChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code DeploymentEnvironmentChangedEvent}; used by the generated selection code only.
 */
final class DeploymentEnvironmentChangedEventSelectorImpl implements DeploymentEnvironmentChangedEventSelector {

    private final Cursor cursor;

    DeploymentEnvironmentChangedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R deploymentStatus(final Function<DeploymentStatusSelector, R> selection) {
        return cursor.objectRequired(
                "deploymentStatus", child -> selection.apply(new DeploymentStatusSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
