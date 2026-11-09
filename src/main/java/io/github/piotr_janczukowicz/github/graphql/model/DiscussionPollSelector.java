package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DiscussionPoll}. */
public interface DiscussionPollSelector {

    <R> @Nullable R discussion(Function<DiscussionSelector, R> selection);

    String id();

    <R> Page<R> options(
            Paging paging, DiscussionPollOptionsFilter arguments, Function<DiscussionPollOptionSelector, R> selection);

    <R> Page<R> options(Paging paging, Function<DiscussionPollOptionSelector, R> selection);

    String question();

    int totalVoteCount();

    boolean viewerCanVote();

    boolean viewerHasVoted();
}
