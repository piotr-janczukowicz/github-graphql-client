package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProfileItemShowcase}. */
public interface ProfileItemShowcaseSelector {

    boolean hasPinnedItems();

    <R> Page<R> items(Paging paging, Function<PinnableItemSelector, R> selection);
}
