package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.GitActorAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.GitActorAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GitActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.OffsetDateTime;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code GitActor}; used by the generated selection code only. */
final class GitActorSelectorImpl implements GitActorSelector {

    private final Cursor cursor;

    GitActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final GitActorAvatarUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(GitActorAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public @Nullable OffsetDateTime date() {
        return cursor.get("date", ScalarType.OFFSET_DATE_TIME);
    }

    @Override
    public @Nullable String email() {
        return cursor.get("email", ScalarType.STRING);
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
