package io.github.piotr_janczukowicz.github.graphql.internal;

import java.util.function.Function;
import tools.jackson.databind.JsonNode;

/**
 * A planned operation, a query or a mutation: the document to send and the way to map the response into the caller's
 * type.
 *
 * @param <R> the caller's result type
 */
public final class Planned<R> {

    private final Function<Cursor, R> replay;
    private final FieldSelection root;
    private final QueryDocument document;

    Planned(final Function<Cursor, R> replay, final FieldSelection root, final QueryDocument document) {
        this.replay = replay;
        this.root = root;
        this.document = document;
    }

    /**
     * Returns the document to send.
     *
     * @return the query text and variables
     */
    public QueryDocument document() {
        return document;
    }

    /**
     * Runs the caller's lambda again, this time over the response.
     *
     * @param data the {@code data} object of the response
     * @return what the lambda builds from the response
     */
    public R map(final JsonNode data) {
        return replay.apply(new MappingCursor(data, root));
    }
}
