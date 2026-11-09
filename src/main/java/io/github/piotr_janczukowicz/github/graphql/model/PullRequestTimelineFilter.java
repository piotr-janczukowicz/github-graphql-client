package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code PullRequest.timeline}; an argument left {@code null} is not sent. */
@RecordBuilder
public record PullRequestTimelineFilter(@Nullable Instant since) {}
