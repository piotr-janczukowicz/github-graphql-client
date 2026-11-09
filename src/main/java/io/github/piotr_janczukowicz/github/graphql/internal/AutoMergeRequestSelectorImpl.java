package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AutoMergeRequest}; used by the generated selection code only. */
final class AutoMergeRequestSelectorImpl implements AutoMergeRequestSelector {

    private final Cursor cursor;

    AutoMergeRequestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String authorEmail() {
        return cursor.get("authorEmail", ScalarType.STRING);
    }

    @Override
    public @Nullable String commitBody() {
        return cursor.get("commitBody", ScalarType.STRING);
    }

    @Override
    public @Nullable String commitHeadline() {
        return cursor.get("commitHeadline", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant enabledAt() {
        return cursor.get("enabledAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R enabledBy(final Function<ActorSelector, R> selection) {
        return cursor.object("enabledBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public PullRequestMergeMethod mergeMethod() {
        return cursor.getRequired(
                "mergeMethod", ScalarType.enumeration(PullRequestMergeMethod::fromWire, PullRequestMergeMethod.MERGE));
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
