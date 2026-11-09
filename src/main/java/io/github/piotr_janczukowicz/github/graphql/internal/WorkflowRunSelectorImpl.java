package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.WorkflowSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code WorkflowRun}; used by the generated selection code only. */
final class WorkflowRunSelectorImpl implements WorkflowRunSelector {

    private final Cursor cursor;

    WorkflowRunSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> R checkSuite(final Function<CheckSuiteSelector, R> selection) {
        return cursor.objectRequired("checkSuite", child -> selection.apply(new CheckSuiteSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> Page<R> deploymentReviews(final Paging paging, final Function<DeploymentReviewSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "deploymentReviews",
                child -> selection.apply(new DeploymentReviewSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public @Nullable String displayTitle() {
        return cursor.get("displayTitle", ScalarType.STRING);
    }

    @Override
    public String event() {
        return cursor.getRequired("event", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R file(final Function<WorkflowRunFileSelector, R> selection) {
        return cursor.object("file", child -> selection.apply(new WorkflowRunFileSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> pendingDeploymentRequests(
            final Paging paging, final Function<DeploymentRequestSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "pendingDeploymentRequests",
                child -> selection.apply(new DeploymentRequestSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public int runAttempt() {
        return cursor.getRequired("runAttempt", ScalarType.INT);
    }

    @Override
    public int runNumber() {
        return cursor.getRequired("runNumber", ScalarType.INT);
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
    public <R> R workflow(final Function<WorkflowSelector, R> selection) {
        return cursor.objectRequired("workflow", child -> selection.apply(new WorkflowSelectorImpl(child)));
    }
}
