package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code TreeEntry}. */
public interface TreeEntrySelector {

    @Nullable String extension();

    boolean isGenerated();

    <R> @Nullable R language(Function<LanguageSelector, R> selection);

    @Nullable Integer lineCount();

    int mode();

    String name();

    String nameRaw();

    <R> @Nullable R object(Function<GitObjectSelector, R> selection);

    String oid();

    @Nullable String path();

    @Nullable String pathRaw();

    <R> R repository(Function<RepositorySelector, R> selection);

    int size();

    <R> @Nullable R submodule(Function<SubmoduleSelector, R> selection);

    String type();
}
