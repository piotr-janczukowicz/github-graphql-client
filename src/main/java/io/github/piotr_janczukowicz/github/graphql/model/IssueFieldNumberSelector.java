package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code IssueFieldNumber}. */
public interface IssueFieldNumberSelector {

    Instant createdAt();

    IssueFieldDataType dataType();

    @Nullable String description();

    @Nullable BigInteger fullDatabaseId();

    String id();

    String name();

    IssueFieldVisibility visibility();
}
