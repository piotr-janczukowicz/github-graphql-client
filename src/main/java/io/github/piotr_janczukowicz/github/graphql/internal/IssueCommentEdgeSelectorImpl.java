package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueCommentEdge}; used by the generated selection code only. */
final class IssueCommentEdgeSelectorImpl implements IssueCommentEdgeSelector {

    private final Cursor cursor;

    IssueCommentEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<IssueCommentSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new IssueCommentSelectorImpl(child)));
    }
}
