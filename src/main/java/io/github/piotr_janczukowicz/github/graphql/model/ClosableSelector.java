package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Closable}. */
public interface ClosableSelector {

    boolean closed();

    @Nullable Instant closedAt();

    boolean viewerCanClose();

    boolean viewerCanReopen();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
