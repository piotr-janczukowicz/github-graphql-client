package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.OffsetDateTime;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Commit.history}; an argument left {@code null} is not sent. */
@RecordBuilder
public record CommitHistoryFilter(
        @Nullable CommitAuthor author,
        @Nullable String path,
        @Nullable OffsetDateTime since,
        @Nullable OffsetDateTime until) {}
