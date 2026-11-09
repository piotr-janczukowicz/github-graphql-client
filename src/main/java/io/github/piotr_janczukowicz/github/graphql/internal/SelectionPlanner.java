package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MutationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import java.util.function.Function;

/**
 * Turns a query lambda into a document by running it once with recording selectors. The lambda must have no side
 * effects and must not branch on a value it reads: it runs a second time to map the response.
 */
public final class SelectionPlanner {

    private SelectionPlanner() {}

    /**
     * Plans a query.
     *
     * @param query reads the fields it needs from the selectors and builds the result
     * @param <R> the result type
     * @return the document and the mapping of the response
     * @throws IllegalArgumentException when the lambda reads no field
     * @throws IllegalStateException when the same field is selected twice with different arguments
     */
    public static <R> Planned<R> plan(final Function<QuerySelector, R> query) {
        return planOperation("query", cursor -> query.apply(Selectors.query(cursor)));
    }

    /**
     * Plans a mutation.
     *
     * @param mutation reads the fields it needs from the selectors and builds the result
     * @param <R> the result type
     * @return the document and the mapping of the response
     * @throws IllegalArgumentException when the lambda reads no field
     * @throws IllegalStateException when the same field is selected twice with different arguments
     */
    public static <R> Planned<R> planMutation(final Function<MutationSelector, R> mutation) {
        return planOperation("mutation", cursor -> mutation.apply(Selectors.mutation(cursor)));
    }

    private static <R> Planned<R> planOperation(final String operation, final Function<Cursor, R> replay) {
        final FieldSelection root = FieldSelection.root(operation);
        replay.apply(new RecordingCursor(root));
        if (root.isEmpty()) {
            throw new IllegalArgumentException("selection reads no field: " + root.path());
        }
        return new Planned<>(replay, root, QueryWriter.write(root));
    }
}
