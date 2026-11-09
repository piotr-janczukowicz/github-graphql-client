package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DiscussionPollOption}. */
public interface DiscussionPollOptionSelector {

    String id();

    String option();

    <R> @Nullable R poll(Function<DiscussionPollSelector, R> selection);

    int totalVoteCount();

    boolean viewerHasVoted();
}
