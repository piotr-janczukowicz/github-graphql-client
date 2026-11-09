package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DiscussionPoll}; used by the generated selection code only. */
final class DiscussionPollSelectorImpl implements DiscussionPollSelector {

    private final Cursor cursor;

    DiscussionPollSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R discussion(final Function<DiscussionSelector, R> selection) {
        return cursor.object("discussion", child -> selection.apply(new DiscussionSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> options(
            final Paging paging,
            final DiscussionPollOptionsFilter arguments,
            final Function<DiscussionPollOptionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "options",
                child -> selection.apply(new DiscussionPollOptionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "DiscussionPollOptionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> options(final Paging paging, final Function<DiscussionPollOptionSelector, R> selection) {
        return options(paging, DiscussionPollOptionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String question() {
        return cursor.getRequired("question", ScalarType.STRING);
    }

    @Override
    public int totalVoteCount() {
        return cursor.getRequired("totalVoteCount", ScalarType.INT);
    }

    @Override
    public boolean viewerCanVote() {
        return cursor.getRequired("viewerCanVote", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerHasVoted() {
        return cursor.getRequired("viewerHasVoted", ScalarType.BOOLEAN);
    }
}
