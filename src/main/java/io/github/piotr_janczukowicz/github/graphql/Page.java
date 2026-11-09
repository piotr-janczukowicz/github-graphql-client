package io.github.piotr_janczukowicz.github.graphql;

import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * One page of a connection (a paged list in GitHub's GraphQL API).
 *
 * <p>To read the next page, ask for the same connection with {@code Paging.first(n).after(page.endCursor())}. Every
 * query is sent with POST, which the GitHub client paces at least one second apart, so reading N pages takes about N-1
 * seconds.
 *
 * @param items the items of this page, without the {@code null} entries GitHub sends for items you may not see; an item
 *     can still be {@code null} when your own selection returns {@code null} for it
 * @param hasNext whether GitHub has more items after this page
 * @param endCursor the cursor of the last item of this page, to continue after it; {@code null} when there is none
 * @param <R> the item type your selection builds
 */
public record Page<R>(
        List<R> items, boolean hasNext, @Nullable String endCursor) {

    public Page {
        items = ListUtils.copyOf(items, "items");
    }
}
