package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code GistFile}. */
public interface GistFileSelector {

    @Nullable String encodedName();

    @Nullable String encoding();

    @Nullable String extension();

    boolean isImage();

    boolean isTruncated();

    <R> @Nullable R language(Function<LanguageSelector, R> selection);

    @Nullable String name();

    @Nullable Integer size();

    @Nullable String text(GistFileTextFilter arguments);

    @Nullable String text();
}
