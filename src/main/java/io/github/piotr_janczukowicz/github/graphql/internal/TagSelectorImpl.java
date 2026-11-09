package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GitActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TagSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Tag}; used by the generated selection code only. */
final class TagSelectorImpl implements TagSelector {

    private final Cursor cursor;

    TagSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String abbreviatedOid() {
        return cursor.getRequired("abbreviatedOid", ScalarType.STRING);
    }

    @Override
    public String commitResourcePath() {
        return cursor.getRequired("commitResourcePath", ScalarType.STRING);
    }

    @Override
    public String commitUrl() {
        return cursor.getRequired("commitUrl", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String oid() {
        return cursor.getRequired("oid", ScalarType.STRING);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R tagger(final Function<GitActorSelector, R> selection) {
        return cursor.object("tagger", child -> selection.apply(new GitActorSelectorImpl(child)));
    }

    @Override
    public <R> R target(final Function<GitObjectSelector, R> selection) {
        return cursor.objectRequired("target", child -> selection.apply(new GitObjectSelectorImpl(child)));
    }
}
