package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeEntrySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code TreeEntry}; used by the generated selection code only. */
final class TreeEntrySelectorImpl implements TreeEntrySelector {

    private final Cursor cursor;

    TreeEntrySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String extension() {
        return cursor.get("extension", ScalarType.STRING);
    }

    @Override
    public boolean isGenerated() {
        return cursor.getRequired("isGenerated", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R language(final Function<LanguageSelector, R> selection) {
        return cursor.object("language", child -> selection.apply(new LanguageSelectorImpl(child)));
    }

    @Override
    public @Nullable Integer lineCount() {
        return cursor.get("lineCount", ScalarType.INT);
    }

    @Override
    public int mode() {
        return cursor.getRequired("mode", ScalarType.INT);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameRaw() {
        return cursor.getRequired("nameRaw", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R object(final Function<GitObjectSelector, R> selection) {
        return cursor.object("object", child -> selection.apply(new GitObjectSelectorImpl(child)));
    }

    @Override
    public String oid() {
        return cursor.getRequired("oid", ScalarType.STRING);
    }

    @Override
    public @Nullable String path() {
        return cursor.get("path", ScalarType.STRING);
    }

    @Override
    public @Nullable String pathRaw() {
        return cursor.get("pathRaw", ScalarType.STRING);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public int size() {
        return cursor.getRequired("size", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R submodule(final Function<SubmoduleSelector, R> selection) {
        return cursor.object("submodule", child -> selection.apply(new SubmoduleSelectorImpl(child)));
    }

    @Override
    public String type() {
        return cursor.getRequired("type", ScalarType.STRING);
    }
}
