package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.NodeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AddCommentPayload}; used by the generated selection code only. */
final class AddCommentPayloadSelectorImpl implements AddCommentPayloadSelector {

    private final Cursor cursor;

    AddCommentPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R commentEdge(final Function<IssueCommentEdgeSelector, R> selection) {
        return cursor.object("commentEdge", child -> selection.apply(new IssueCommentEdgeSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R subject(final Function<NodeSelector, R> selection) {
        return cursor.object("subject", child -> selection.apply(new NodeSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R timelineEdge(final Function<IssueTimelineItemEdgeSelector, R> selection) {
        return cursor.object("timelineEdge", child -> selection.apply(new IssueTimelineItemEdgeSelectorImpl(child)));
    }
}
