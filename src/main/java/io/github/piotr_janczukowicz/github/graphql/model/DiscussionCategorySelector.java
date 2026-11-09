package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DiscussionCategory}. */
public interface DiscussionCategorySelector {

    Instant createdAt();

    @Nullable String description();

    String emoji();

    String emojiHTML();

    String id();

    boolean isAnswerable();

    String name();

    <R> R repository(Function<RepositorySelector, R> selection);

    String slug();

    Instant updatedAt();
}
