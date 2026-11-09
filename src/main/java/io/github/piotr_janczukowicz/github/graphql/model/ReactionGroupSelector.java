package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReactionGroup}. */
public interface ReactionGroupSelector {

    ReactionContent content();

    @Nullable Instant createdAt();

    <R> Page<R> reactors(Paging paging, Function<ReactorSelector, R> selection);

    <R> R subject(Function<ReactableSelector, R> selection);

    /**
     * @deprecated Reactors can now be mannequins, bots, and organizations. Use the `reactors` field instead. Removal on
     *     2021-10-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> users(Paging paging, Function<UserSelector, R> selection);

    boolean viewerHasReacted();
}
