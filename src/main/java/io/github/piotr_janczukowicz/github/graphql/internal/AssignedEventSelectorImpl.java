package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AssignedEvent}; used by the generated selection code only. */
final class AssignedEventSelectorImpl implements AssignedEventSelector {

    private final Cursor cursor;

    AssignedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R assignable(final Function<AssignableSelector, R> selection) {
        return cursor.objectRequired("assignable", child -> selection.apply(new AssignableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R assignee(final Function<AssigneeSelector, R> selection) {
        return cursor.object("assignee", child -> selection.apply(new AssigneeSelectorImpl(child)));
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

    /** @deprecated Assignees can now be mannequins. Use the `assignee` field instead. Removal on 2020-01-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
