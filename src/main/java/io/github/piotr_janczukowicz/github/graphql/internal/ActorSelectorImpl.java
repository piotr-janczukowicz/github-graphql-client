package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.ActorAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ActorAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Actor}; used by the generated selection code only. */
final class ActorSelectorImpl implements ActorSelector {

    private final Cursor cursor;

    ActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final ActorAvatarUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(ActorAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ActorSelector.class, type, selection);
    }
}
