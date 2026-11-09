package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeast;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtMost;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.pagination.PaginationConfiguration;
import org.jspecify.annotations.Nullable;

/**
 * Which page of a connection to read: how many items, and optionally after which cursor.
 *
 * <p>Start with {@code Paging.first(50)}; while {@link Page#hasNext()} is true, read the next page with
 * {@code Paging.first(50).after(page.endCursor())}. The end cursor is {@code null} on a last page that has no items, so
 * check {@code hasNext()} before using it. Every query is sent with POST, which the GitHub client paces at least one
 * second apart, so reading N pages takes about N-1 seconds.
 */
public final class Paging {

    private final int first;
    private final @Nullable String after;

    private Paging(final int first, final @Nullable String after) {
        this.first = first;
        this.after = after;
    }

    /**
     * Reads the first {@code count} items.
     *
     * @param count how many items, from 1 to 100 (GitHub's limit)
     * @return the paging for the first page
     * @throws IllegalArgumentException when {@code count} is outside 1 to 100
     */
    public static Paging first(final int count) {
        requireAtLeast(count, 1, "first");
        requireAtMost(count, PaginationConfiguration.MAX_PER_PAGE, "first");
        return new Paging(count, null);
    }

    /**
     * Returns how many items are read.
     *
     * @return the count, from 1 to 100
     */
    public int first() {
        return first;
    }

    /**
     * Reads the same number of items after a cursor.
     *
     * @param cursor the {@link Page#endCursor() end cursor} of the previous page
     * @return the paging for the next page
     * @throws NullPointerException when {@code cursor} is {@code null}
     */
    public Paging after(final String cursor) {
        return new Paging(first, requireNonNull(cursor, "cursor"));
    }

    /**
     * Returns the cursor to continue after.
     *
     * @return the cursor, or {@code null} for the first page
     */
    public @Nullable String after() {
        return after;
    }
}
