package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RejectDeploymentsPayloadSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RejectDeploymentsPayload}; used by the generated selection code only. */
final class RejectDeploymentsPayloadSelectorImpl implements RejectDeploymentsPayloadSelector {

    private final Cursor cursor;

    RejectDeploymentsPayloadSelectorImpl(final Cursor cursor) {
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
