package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PinnableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProfileItemShowcaseSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ProfileItemShowcase}; used by the generated selection code only. */
final class ProfileItemShowcaseSelectorImpl implements ProfileItemShowcaseSelector {

    private final Cursor cursor;

    ProfileItemShowcaseSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasPinnedItems() {
        return cursor.getRequired("hasPinnedItems", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> items(final Paging paging, final Function<PinnableItemSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "items",
                child -> selection.apply(new PinnableItemSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
