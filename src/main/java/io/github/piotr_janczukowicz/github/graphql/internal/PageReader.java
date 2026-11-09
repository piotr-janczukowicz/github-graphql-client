package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.Page;
import java.util.List;
import java.util.function.Function;
import tools.jackson.databind.JsonNode;

final class PageReader {

    private PageReader() {}

    static <R> Page<R> read(
            final JsonNode connection, final FieldSelection recorded, final Function<Cursor, R> itemReader) {
        final List<R> items = new MappingCursor(connection, recorded).list("nodes", itemReader);
        final JsonNode pageInfo = requirePresent(connection, "pageInfo", recorded.path());
        final JsonNode nextPage = requirePresent(pageInfo, "hasNextPage", recorded.path() + ".pageInfo");
        final JsonNode endCursor = pageInfo.path("endCursor");
        final String cursor = endCursor.isMissingNode() || endCursor.isNull() ? null : endCursor.asString();
        return new Page<>(items, nextPage.asBoolean(), cursor);
    }

    private static JsonNode requirePresent(final JsonNode parent, final String field, final String path) {
        final JsonNode value = parent.get(field);
        if (value == null || value.isNull()) {
            throw new IllegalStateException("non-null field " + path + "." + field + " is null in the response");
        }
        return value;
    }
}
