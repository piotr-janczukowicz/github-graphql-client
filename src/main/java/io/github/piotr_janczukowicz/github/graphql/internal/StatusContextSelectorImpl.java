package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextIsRequiredFilter;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextIsRequiredFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusState;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code StatusContext}; used by the generated selection code only. */
final class StatusContextSelectorImpl implements StatusContextSelector {

    private final Cursor cursor;

    StatusContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String avatarUrl(final StatusContextAvatarUrlFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.get("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public @Nullable String avatarUrl() {
        return avatarUrl(StatusContextAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public <R> @Nullable R commit(final Function<CommitSelector, R> selection) {
        return cursor.object("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public String context() {
        return cursor.getRequired("context", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isRequired(final StatusContextIsRequiredFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired(
                "isRequired",
                ScalarType.BOOLEAN,
                Argument.of("pullRequestId", "ID", arguments.pullRequestId()),
                Argument.of("pullRequestNumber", "Int", arguments.pullRequestNumber()));
    }

    @Override
    public boolean isRequired() {
        return isRequired(StatusContextIsRequiredFilterBuilder.builder().build());
    }

    @Override
    public StatusState state() {
        return cursor.getRequired("state", ScalarType.enumeration(StatusState::fromWire, StatusState.ERROR));
    }

    @Override
    public @Nullable String targetUrl() {
        return cursor.get("targetUrl", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
