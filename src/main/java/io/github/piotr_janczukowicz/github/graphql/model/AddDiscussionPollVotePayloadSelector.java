package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddDiscussionPollVotePayload}. */
public interface AddDiscussionPollVotePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R pollOption(Function<DiscussionPollOptionSelector, R> selection);
}
