package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldSingleSelect}. */
public interface IssueFieldSingleSelectSelector {

    Instant createdAt();

    IssueFieldDataType dataType();

    @Nullable String description();

    @Nullable BigInteger fullDatabaseId();

    String id();

    String name();

    <R> List<R> options(Function<IssueFieldSingleSelectOptionSelector, R> selection);

    IssueFieldVisibility visibility();
}
