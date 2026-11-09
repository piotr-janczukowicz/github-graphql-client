package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Push}; used by the generated selection code only. */
final class PushSelectorImpl implements PushSelector {

    private final Cursor cursor;

    PushSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String nextSha() {
        return cursor.get("nextSha", ScalarType.STRING);
    }

    @Override
    public String permalink() {
        return cursor.getRequired("permalink", ScalarType.STRING);
    }

    @Override
    public @Nullable String previousSha() {
        return cursor.get("previousSha", ScalarType.STRING);
    }

    @Override
    public <R> R pusher(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("pusher", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
