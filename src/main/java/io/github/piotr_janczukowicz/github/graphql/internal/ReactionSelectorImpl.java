package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Reaction}; used by the generated selection code only. */
final class ReactionSelectorImpl implements ReactionSelector {

    private final Cursor cursor;

    ReactionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ReactionContent content() {
        return cursor.getRequired(
                "content", ScalarType.enumeration(ReactionContent::fromWire, ReactionContent.CONFUSED));
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R reactable(final Function<ReactableSelector, R> selection) {
        return cursor.objectRequired("reactable", child -> selection.apply(new ReactableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
