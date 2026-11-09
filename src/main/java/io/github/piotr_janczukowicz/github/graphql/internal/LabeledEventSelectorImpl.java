package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabeledEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code LabeledEvent}; used by the generated selection code only. */
final class LabeledEventSelectorImpl implements LabeledEventSelector {

    private final Cursor cursor;

    LabeledEventSelectorImpl(final Cursor cursor) {
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R intent(final Function<IssueUpdateIntentSelector, R> selection) {
        return cursor.object("intent", child -> selection.apply(new IssueUpdateIntentSelectorImpl(child)));
    }

    @Override
    public <R> R label(final Function<LabelSelector, R> selection) {
        return cursor.objectRequired("label", child -> selection.apply(new LabelSelectorImpl(child)));
    }

    @Override
    public <R> R labelable(final Function<LabelableSelector, R> selection) {
        return cursor.objectRequired("labelable", child -> selection.apply(new LabelableSelectorImpl(child)));
    }
}
