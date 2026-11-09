package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCommitCommentThreadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code PullRequestCommitCommentThread}; used by the generated selection code only.
 */
final class PullRequestCommitCommentThreadSelectorImpl implements PullRequestCommitCommentThreadSelector {

    private final Cursor cursor;

    PullRequestCommitCommentThreadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<CommitCommentSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new CommitCommentSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> R commit(final Function<CommitSelector, R> selection) {
        return cursor.objectRequired("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String path() {
        return cursor.get("path", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer position() {
        return cursor.get("position", ScalarType.INT);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
