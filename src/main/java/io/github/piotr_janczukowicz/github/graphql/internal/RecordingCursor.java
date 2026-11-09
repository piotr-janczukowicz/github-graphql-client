package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.Page;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

final class RecordingCursor implements Cursor {

    private static final String TYPENAME = "__typename";
    private static final String READS_NO_FIELD = "selection reads no field: ";

    private final FieldSelection selection;

    RecordingCursor(final FieldSelection selection) {
        this.selection = selection;
    }

    @Override
    public <T> T get(final String field, final ScalarType<T> type, final Argument... arguments) {
        selection.select(field, List.of(arguments));
        return type.placeholder();
    }

    @Override
    public <T> T getRequired(final String field, final ScalarType<T> type, final Argument... arguments) {
        return get(field, type, arguments);
    }

    @Override
    public <R> R object(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        final FieldSelection child = selection.select(field, List.of(arguments));
        final R result = reader.apply(new RecordingCursor(child));
        if (child.isEmpty()) {
            throw new IllegalArgumentException(READS_NO_FIELD + child.path());
        }
        return result;
    }

    @Override
    public <R> R objectRequired(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        return object(field, reader, arguments);
    }

    @Override
    public <R> R branch(final String typeName, final Function<Cursor, R> reader) {
        selection.select(TYPENAME, List.of());
        final FieldSelection fragment = selection.select(FieldSelection.fragmentName(typeName), List.of());
        final R result = reader.apply(new RecordingCursor(fragment));
        if (fragment.isEmpty()) {
            throw new IllegalArgumentException(READS_NO_FIELD + fragment.path());
        }
        return result;
    }

    @Override
    public <R> List<R> list(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        return Collections.singletonList(object(field, reader, arguments));
    }

    @Override
    public <R> List<R> listRequired(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        return list(field, reader, arguments);
    }

    @Override
    public <T> List<T> scalarList(final String field, final ScalarType<T> type, final Argument... arguments) {
        selection.select(field, List.of(arguments));
        return Collections.singletonList(type.placeholder());
    }

    @Override
    public <T> List<T> scalarListRequired(final String field, final ScalarType<T> type, final Argument... arguments) {
        return scalarList(field, type, arguments);
    }

    @Override
    public <R> Page<R> pageRequired(
            final String field, final Function<Cursor, R> itemReader, final Argument... arguments) {
        return page(field, itemReader, arguments);
    }

    @Override
    public <R> Page<R> page(final String field, final Function<Cursor, R> itemReader, final Argument... arguments) {
        final FieldSelection connection = selection.select(field, List.of(arguments));
        final FieldSelection nodes = connection.select("nodes", List.of());
        final R item = itemReader.apply(new RecordingCursor(nodes));
        if (nodes.isEmpty()) {
            throw new IllegalArgumentException(READS_NO_FIELD + nodes.path());
        }
        final FieldSelection pageInfo = connection.select("pageInfo", List.of());
        pageInfo.select("hasNextPage", List.of());
        pageInfo.select("endCursor", List.of());
        return new Page<>(Collections.singletonList(item), false, null);
    }
}
