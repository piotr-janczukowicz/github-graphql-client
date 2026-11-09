package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PinnedIssue}. */
public interface PinnedIssueSelector {

    @Nullable Integer databaseId();

    @Nullable BigInteger fullDatabaseId();

    String id();

    <R> R issue(Function<IssueSelector, R> selection);

    <R> R pinnedBy(Function<ActorSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);
}
