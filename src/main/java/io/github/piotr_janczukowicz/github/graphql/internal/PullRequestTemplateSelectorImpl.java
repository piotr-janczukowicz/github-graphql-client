package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestTemplate}; used by the generated selection code only. */
final class PullRequestTemplateSelectorImpl implements PullRequestTemplateSelector {

    private final Cursor cursor;

    PullRequestTemplateSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String body() {
        return cursor.get("body", ScalarType.STRING);
    }

    @Override
    public @Nullable String filename() {
        return cursor.get("filename", ScalarType.STRING);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
