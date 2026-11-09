package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionGradient;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionPattern;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinnedDiscussion}; used by the generated selection code only. */
final class PinnedDiscussionSelectorImpl implements PinnedDiscussionSelector {

    private final Cursor cursor;

    PinnedDiscussionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public <R> R discussion(final Function<DiscussionSelector, R> selection) {
        return cursor.objectRequired("discussion", child -> selection.apply(new DiscussionSelectorImpl(child)));
    }

    @Override
    public List<String> gradientStopColors() {
        return cursor.scalarListRequired("gradientStopColors", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public PinnedDiscussionPattern pattern() {
        return cursor.getRequired(
                "pattern",
                ScalarType.enumeration(PinnedDiscussionPattern::fromWire, PinnedDiscussionPattern.CHEVRON_UP));
    }

    @Override
    public <R> R pinnedBy(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("pinnedBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable PinnedDiscussionGradient preconfiguredGradient() {
        return cursor.get(
                "preconfiguredGradient",
                ScalarType.enumeration(PinnedDiscussionGradient::fromWire, PinnedDiscussionGradient.BLUE_MINT));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
