package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueTimelineItemEdge}; used by the generated selection code only. */
final class IssueTimelineItemEdgeSelectorImpl implements IssueTimelineItemEdgeSelector {

    private final Cursor cursor;

    IssueTimelineItemEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<IssueTimelineItemSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new IssueTimelineItemSelectorImpl(child)));
    }
}
