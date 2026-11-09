package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AddedToProjectV2EventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddedToProjectV2Event}; used by the generated selection code only. */
final class AddedToProjectV2EventSelectorImpl implements AddedToProjectV2EventSelector {

    private final Cursor cursor;

    AddedToProjectV2EventSelectorImpl(final Cursor cursor) {
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
    public <R> @Nullable R project(final Function<ProjectV2Selector, R> selection) {
        return cursor.object("project", child -> selection.apply(new ProjectV2SelectorImpl(child)));
    }

    @Override
    public boolean wasAutomated() {
        return cursor.getRequired("wasAutomated", ScalarType.BOOLEAN);
    }
}
