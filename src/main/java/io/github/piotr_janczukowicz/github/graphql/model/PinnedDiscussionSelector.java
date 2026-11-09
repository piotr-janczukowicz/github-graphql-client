package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PinnedDiscussion}. */
public interface PinnedDiscussionSelector {

    Instant createdAt();

    @Nullable Integer databaseId();

    <R> R discussion(Function<DiscussionSelector, R> selection);

    List<String> gradientStopColors();

    String id();

    PinnedDiscussionPattern pattern();

    <R> R pinnedBy(Function<ActorSelector, R> selection);

    @Nullable PinnedDiscussionGradient preconfiguredGradient();

    <R> R repository(Function<RepositorySelector, R> selection);

    Instant updatedAt();
}
