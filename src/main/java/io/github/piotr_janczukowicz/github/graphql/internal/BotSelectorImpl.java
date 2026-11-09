package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.BotAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.BotAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Bot}; used by the generated selection code only. */
final class BotSelectorImpl implements BotSelector {

    private final Cursor cursor;

    BotSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final BotAvatarUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(BotAvatarUrlFilterBuilder.builder().build());
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
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
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
