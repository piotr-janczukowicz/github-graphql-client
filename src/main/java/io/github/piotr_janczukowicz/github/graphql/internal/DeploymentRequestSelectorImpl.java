package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeploymentRequest}; used by the generated selection code only. */
final class DeploymentRequestSelectorImpl implements DeploymentRequestSelector {

    private final Cursor cursor;

    DeploymentRequestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean currentUserCanApprove() {
        return cursor.getRequired("currentUserCanApprove", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R environment(final Function<EnvironmentSelector, R> selection) {
        return cursor.objectRequired("environment", child -> selection.apply(new EnvironmentSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reviewers(final Paging paging, final Function<DeploymentReviewerSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "reviewers",
                child -> selection.apply(new DeploymentReviewerSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public int waitTimer() {
        return cursor.getRequired("waitTimer", ScalarType.INT);
    }

    @Override
    public @Nullable Instant waitTimerStartedAt() {
        return cursor.get("waitTimerStartedAt", ScalarType.INSTANT);
    }
}
