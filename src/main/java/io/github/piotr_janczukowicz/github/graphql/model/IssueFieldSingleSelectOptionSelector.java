package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldSingleSelectOption}. */
public interface IssueFieldSingleSelectOptionSelector {

    IssueFieldSingleSelectOptionColor color();

    @Nullable Integer databaseId();

    @Nullable String description();

    @Nullable BigInteger fullDatabaseId();

    String id();

    String name();

    @Nullable Integer priority();
}
