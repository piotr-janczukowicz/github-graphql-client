package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PinnedIssueComment}. */
public interface PinnedIssueCommentSelector {

    @Nullable Integer databaseId();

    @Nullable BigInteger fullDatabaseId();

    String id();

    <R> R issue(Function<IssueSelector, R> selection);

    <R> R issueComment(Function<IssueCommentSelector, R> selection);

    Instant pinnedAt();

    <R> R pinnedBy(Function<ActorSelector, R> selection);
}
