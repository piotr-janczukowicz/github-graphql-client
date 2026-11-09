package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunIsRequiredFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunIsRequiredFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunStepsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CheckRunStepsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStepSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CheckRun}; used by the generated selection code only. */
final class CheckRunSelectorImpl implements CheckRunSelector {

    private final Cursor cursor;

    CheckRunSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> annotations(final Paging paging, final Function<CheckAnnotationSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "annotations",
                child -> selection.apply(new CheckAnnotationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> R checkSuite(final Function<CheckSuiteSelector, R> selection) {
        return cursor.objectRequired("checkSuite", child -> selection.apply(new CheckSuiteSelectorImpl(child)));
    }

    @Override
    public @Nullable Instant completedAt() {
        return cursor.get("completedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable CheckConclusionState conclusion() {
        return cursor.get(
                "conclusion",
                ScalarType.enumeration(CheckConclusionState::fromWire, CheckConclusionState.ACTION_REQUIRED));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R deployment(final Function<DeploymentSelector, R> selection) {
        return cursor.object("deployment", child -> selection.apply(new DeploymentSelectorImpl(child)));
    }

    @Override
    public @Nullable String detailsUrl() {
        return cursor.get("detailsUrl", ScalarType.STRING);
    }

    @Override
    public @Nullable String externalId() {
        return cursor.get("externalId", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isRequired(final CheckRunIsRequiredFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired(
                "isRequired",
                ScalarType.BOOLEAN,
                Argument.of("pullRequestId", "ID", arguments.pullRequestId()),
                Argument.of("pullRequestNumber", "Int", arguments.pullRequestNumber()));
    }

    @Override
    public boolean isRequired() {
        return isRequired(CheckRunIsRequiredFilterBuilder.builder().build());
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pendingDeploymentRequest(final Function<DeploymentRequestSelector, R> selection) {
        return cursor.object(
                "pendingDeploymentRequest", child -> selection.apply(new DeploymentRequestSelectorImpl(child)));
    }

    @Override
    public String permalink() {
        return cursor.getRequired("permalink", ScalarType.STRING);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant startedAt() {
        return cursor.get("startedAt", ScalarType.INSTANT);
    }

    @Override
    public CheckStatusState status() {
        return cursor.getRequired(
                "status", ScalarType.enumeration(CheckStatusState::fromWire, CheckStatusState.COMPLETED));
    }

    @Override
    public <R> Page<R> steps(
            final Paging paging, final CheckRunStepsFilter arguments, final Function<CheckStepSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "steps",
                child -> selection.apply(new CheckStepSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("number", "Int", arguments.number()));
    }

    @Override
    public <R> Page<R> steps(final Paging paging, final Function<CheckStepSelector, R> selection) {
        return steps(paging, CheckRunStepsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable String summary() {
        return cursor.get("summary", ScalarType.STRING);
    }

    @Override
    public @Nullable String text() {
        return cursor.get("text", ScalarType.STRING);
    }

    @Override
    public @Nullable String title() {
        return cursor.get("title", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
