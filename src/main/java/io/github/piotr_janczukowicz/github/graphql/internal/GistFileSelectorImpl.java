package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.GistFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistFileTextFilter;
import io.github.piotr_janczukowicz.github.graphql.model.GistFileTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code GistFile}; used by the generated selection code only. */
final class GistFileSelectorImpl implements GistFileSelector {

    private final Cursor cursor;

    GistFileSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String encodedName() {
        return cursor.get("encodedName", ScalarType.STRING);
    }

    @Override
    public @Nullable String encoding() {
        return cursor.get("encoding", ScalarType.STRING);
    }

    @Override
    public @Nullable String extension() {
        return cursor.get("extension", ScalarType.STRING);
    }

    @Override
    public boolean isImage() {
        return cursor.getRequired("isImage", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isTruncated() {
        return cursor.getRequired("isTruncated", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R language(final Function<LanguageSelector, R> selection) {
        return cursor.object("language", child -> selection.apply(new LanguageSelectorImpl(child)));
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer size() {
        return cursor.get("size", ScalarType.INT);
    }

    @Override
    public @Nullable String text(final GistFileTextFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.get("text", ScalarType.STRING, Argument.of("truncate", "Int", arguments.truncate()));
    }

    @Override
    public @Nullable String text() {
        return text(GistFileTextFilterBuilder.builder().build());
    }
}
