package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.MannequinAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.MannequinSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Mannequin}; used by the generated selection code only. */
final class MannequinSelectorImpl implements MannequinSelector {

    private final Cursor cursor;

    MannequinSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final MannequinAvatarUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(MannequinAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public <R> @Nullable R claimant(final Function<UserSelector, R> selection) {
        return cursor.object("claimant", child -> selection.apply(new UserSelectorImpl(child)));
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
    public @Nullable String email() {
        return cursor.get("email", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
