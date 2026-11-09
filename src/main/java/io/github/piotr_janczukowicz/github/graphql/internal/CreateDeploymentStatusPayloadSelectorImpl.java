package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateDeploymentStatusPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentStatusSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateDeploymentStatusPayload}; used by the generated selection code only. */
final class CreateDeploymentStatusPayloadSelectorImpl implements CreateDeploymentStatusPayloadSelector {

    private final Cursor cursor;

    CreateDeploymentStatusPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R deploymentStatus(final Function<DeploymentStatusSelector, R> selection) {
        return cursor.object("deploymentStatus", child -> selection.apply(new DeploymentStatusSelectorImpl(child)));
    }
}
