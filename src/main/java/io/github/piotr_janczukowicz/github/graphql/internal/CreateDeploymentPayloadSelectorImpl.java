package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateDeploymentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateDeploymentPayload}; used by the generated selection code only. */
final class CreateDeploymentPayloadSelectorImpl implements CreateDeploymentPayloadSelector {

    private final Cursor cursor;

    CreateDeploymentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Boolean autoMerged() {
        return cursor.get("autoMerged", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R deployment(final Function<DeploymentSelector, R> selection) {
        return cursor.object("deployment", child -> selection.apply(new DeploymentSelectorImpl(child)));
    }
}
