package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldChangedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTimelineOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldChangedEvent}; used by the generated selection code only. */
final class IssueFieldChangedEventSelectorImpl implements IssueFieldChangedEventSelector {

    private final Cursor cursor;

    IssueFieldChangedEventSelectorImpl(final Cursor cursor) {
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
    public <R> @Nullable R issueField(final Function<IssueFieldsSelector, R> selection) {
        return cursor.object("issueField", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }

    @Override
    public @Nullable String newColor() {
        return cursor.get("newColor", ScalarType.STRING);
    }

    @Override
    public <R> List<R> newOptions(final Function<IssueFieldTimelineOptionSelector, R> selection) {
        return cursor.list("newOptions", child -> selection.apply(new IssueFieldTimelineOptionSelectorImpl(child)));
    }

    @Override
    public @Nullable String newValue() {
        return cursor.get("newValue", ScalarType.STRING);
    }

    @Override
    public @Nullable String previousColor() {
        return cursor.get("previousColor", ScalarType.STRING);
    }

    @Override
    public <R> List<R> previousOptions(final Function<IssueFieldTimelineOptionSelector, R> selection) {
        return cursor.list(
                "previousOptions", child -> selection.apply(new IssueFieldTimelineOptionSelectorImpl(child)));
    }

    @Override
    public @Nullable String previousValue() {
        return cursor.get("previousValue", ScalarType.STRING);
    }
}
