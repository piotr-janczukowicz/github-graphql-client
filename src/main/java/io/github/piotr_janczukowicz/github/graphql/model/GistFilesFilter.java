package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Gist.files}; an argument left {@code null} is not sent. */
@RecordBuilder
public record GistFilesFilter(
        @Nullable Integer limit, @Nullable String oid) {}
