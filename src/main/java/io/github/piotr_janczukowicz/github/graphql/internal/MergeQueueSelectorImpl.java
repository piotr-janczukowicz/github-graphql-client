package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MergeQueue}; used by the generated selection code only. */
final class MergeQueueSelectorImpl implements MergeQueueSelector {

    private final Cursor cursor;

    MergeQueueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R configuration(final Function<MergeQueueConfigurationSelector, R> selection) {
        return cursor.object("configuration", child -> selection.apply(new MergeQueueConfigurationSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> entries(final Paging paging, final Function<MergeQueueEntrySelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "entries",
                child -> selection.apply(new MergeQueueEntrySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer nextEntryEstimatedTimeToMerge() {
        return cursor.get("nextEntryEstimatedTimeToMerge", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
