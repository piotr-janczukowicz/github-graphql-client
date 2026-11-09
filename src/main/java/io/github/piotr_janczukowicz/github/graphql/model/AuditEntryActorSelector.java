package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AuditEntryActor}. */
public interface AuditEntryActorSelector {

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
