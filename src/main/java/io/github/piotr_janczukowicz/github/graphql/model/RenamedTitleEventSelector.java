package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RenamedTitleEvent}. */
public interface RenamedTitleEventSelector {

    <R> @Nullable R actor(Function<ActorSelector, R> selection);

    Instant createdAt();

    String currentTitle();

    String id();

    String previousTitle();

    <R> R subject(Function<RenamedTitleSubjectSelector, R> selection);
}
