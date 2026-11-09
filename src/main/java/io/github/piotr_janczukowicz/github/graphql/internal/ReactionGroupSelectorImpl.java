package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReactionGroup}; used by the generated selection code only. */
final class ReactionGroupSelectorImpl implements ReactionGroupSelector {

    private final Cursor cursor;

    ReactionGroupSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ReactionContent content() {
        return cursor.getRequired(
                "content", ScalarType.enumeration(ReactionContent::fromWire, ReactionContent.CONFUSED));
    }

    @Override
    public @Nullable Instant createdAt() {
        return cursor.get("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> reactors(final Paging paging, final Function<ReactorSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "reactors",
                child -> selection.apply(new ReactorSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> R subject(final Function<ReactableSelector, R> selection) {
        return cursor.objectRequired("subject", child -> selection.apply(new ReactableSelectorImpl(child)));
    }

    /**
     * @deprecated Reactors can now be mannequins, bots, and organizations. Use the `reactors` field instead. Removal on
     *     2021-10-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> Page<R> users(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "users",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public boolean viewerHasReacted() {
        return cursor.getRequired("viewerHasReacted", ScalarType.BOOLEAN);
    }
}
