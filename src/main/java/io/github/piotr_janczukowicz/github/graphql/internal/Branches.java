package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads the {@code ... on Type} fragments of interface and union selectors; used by the generated code only. */
final class Branches {

    private Branches() {}

    static <S, R> @Nullable R on(
            final Cursor cursor, final Class<?> abstractType, final Class<S> type, final Function<S, R> selection) {
        requireNonNull(type, "type");
        requireNonNull(selection, "selection");
        final Branch branch = Selectors.branch(type);
        if (branch == null || !Selectors.possible(abstractType).contains(type)) {
            throw new IllegalArgumentException(
                    type.getSimpleName() + " is not a possible type of " + abstractType.getSimpleName());
        }
        return cursor.branch(
                branch.typeName(),
                child -> selection.apply(type.cast(branch.factory().apply(child))));
    }
}
