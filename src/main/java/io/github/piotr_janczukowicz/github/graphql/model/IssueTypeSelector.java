package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueType}. */
public interface IssueTypeSelector {

    IssueTypeColor color();

    @Nullable String description();

    String id();

    boolean isEnabled();

    /** @deprecated Private issue types are being deprecated and can no longer be created. Removal on 2025-04-01 UTC. */
    @Deprecated(forRemoval = true)
    boolean isPrivate();

    <R> Page<R> issues(
            String repositoryId, Paging paging, IssueTypeIssuesFilter arguments, Function<IssueSelector, R> selection);

    <R> Page<R> issues(String repositoryId, Paging paging, Function<IssueSelector, R> selection);

    String name();

    <R> List<R> pinnedFields(Function<IssueFieldsSelector, R> selection);
}
