package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.pinnableItems}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserPinnableItemsFilter(@Nullable List<PinnableItemType> types) {

    public UserPinnableItemsFilter {
        types = ListUtils.copyOrNull(types);
    }
}
