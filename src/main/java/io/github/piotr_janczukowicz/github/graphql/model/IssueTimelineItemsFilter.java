package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Issue.timelineItems}; an argument left {@code null} is not sent. */
@RecordBuilder
public record IssueTimelineItemsFilter(
        @Nullable List<IssueTimelineItemsItemType> itemTypes,
        @Nullable Instant since,
        @Nullable Integer skip) {

    public IssueTimelineItemsFilter {
        itemTypes = ListUtils.copyOrNull(itemTypes);
    }
}
