package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.topRepositories}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserTopRepositoriesFilter(@Nullable Instant since) {}
