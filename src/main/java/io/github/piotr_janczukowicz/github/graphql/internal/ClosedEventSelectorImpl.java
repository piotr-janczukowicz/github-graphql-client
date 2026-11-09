package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ClosedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CloserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ClosedEvent}; used by the generated selection code only. */
final class ClosedEventSelectorImpl implements ClosedEventSelector {

    private final Cursor cursor;

    ClosedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R closable(final Function<ClosableSelector, R> selection) {
        return cursor.objectRequired("closable", child -> selection.apply(new ClosableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R closer(final Function<CloserSelector, R> selection) {
        return cursor.object("closer", child -> selection.apply(new CloserSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R duplicateOf(final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object("duplicateOf", child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R intent(final Function<IssueUpdateIntentSelector, R> selection) {
        return cursor.object("intent", child -> selection.apply(new IssueUpdateIntentSelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable IssueStateReason stateReason() {
        return cursor.get(
                "stateReason", ScalarType.enumeration(IssueStateReason::fromWire, IssueStateReason.COMPLETED));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
