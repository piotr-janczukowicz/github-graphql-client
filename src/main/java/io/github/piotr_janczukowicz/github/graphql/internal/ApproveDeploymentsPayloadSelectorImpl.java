package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ApproveDeploymentsPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ApproveDeploymentsPayload}; used by the generated selection code only. */
final class ApproveDeploymentsPayloadSelectorImpl implements ApproveDeploymentsPayloadSelector {

    private final Cursor cursor;

    ApproveDeploymentsPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> List<R> deployments(final Function<DeploymentSelector, R> selection) {
        return cursor.list("deployments", child -> selection.apply(new DeploymentSelectorImpl(child)));
    }
}
