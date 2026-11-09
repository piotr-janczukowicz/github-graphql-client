package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.Page;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;
import tools.jackson.databind.JsonNode;

final class MappingCursor implements Cursor {

    private static final String FIELD_PREFIX = "field ";

    private final JsonNode node;
    private final FieldSelection selection;

    MappingCursor(final JsonNode node, final FieldSelection selection) {
        this.node = node;
        this.selection = selection;
    }

    @Override
    public <T> @Nullable T get(final String field, final ScalarType<T> type, final Argument... arguments) {
        requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            return null;
        }
        return parse(field, value, type);
    }

    @Override
    public <T> T getRequired(final String field, final ScalarType<T> type, final Argument... arguments) {
        final T value = get(field, type, arguments);
        if (value == null) {
            throw nullField(field);
        }
        return value;
    }

    @Override
    public <T> List<T> scalarList(final String field, final ScalarType<T> type, final Argument... arguments) {
        requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            return List.of();
        }
        return parseAll(field, value, type);
    }

    @Override
    public <T> List<T> scalarListRequired(final String field, final ScalarType<T> type, final Argument... arguments) {
        requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            throw nullField(field);
        }
        return parseAll(field, value, type);
    }

    @Override
    public <R> @Nullable R object(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        final FieldSelection recorded = requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            return null;
        }
        return reader.apply(new MappingCursor(value, recorded));
    }

    @Override
    public <R> R objectRequired(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        final R result = object(field, reader, arguments);
        if (result == null) {
            throw nullField(field);
        }
        return result;
    }

    @Override
    public <R> @Nullable R branch(final String typeName, final Function<Cursor, R> reader) {
        final FieldSelection fragment = requireRecorded(FieldSelection.fragmentName(typeName));
        if (!typeName.equals(node.path("__typename").asString(""))) {
            return null;
        }
        return reader.apply(new MappingCursor(node, fragment));
    }

    @Override
    public <R> List<R> list(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        final FieldSelection recorded = requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            return List.of();
        }
        if (!value.isArray()) {
            throw notAList(field);
        }
        return value.valueStream()
                .filter(element -> !element.isNull())
                .map(element -> reader.apply(new MappingCursor(element, recorded)))
                .toList();
    }

    @Override
    public <R> List<R> listRequired(final String field, final Function<Cursor, R> reader, final Argument... arguments) {
        requireRecorded(field);
        final JsonNode value = node.get(field);
        if (value == null || value.isNull()) {
            throw nullField(field);
        }
        return list(field, reader, arguments);
    }

    @Override
    public <R> Page<R> page(final String field, final Function<Cursor, R> itemReader, final Argument... arguments) {
        final FieldSelection recorded = requireRecorded(field);
        final JsonNode connection = node.get(field);
        if (connection == null || connection.isNull()) {
            return new Page<>(List.of(), false, null);
        }
        return PageReader.read(connection, recorded, itemReader);
    }

    @Override
    public <R> Page<R> pageRequired(
            final String field, final Function<Cursor, R> itemReader, final Argument... arguments) {
        final FieldSelection recorded = requireRecorded(field);
        final JsonNode connection = node.get(field);
        if (connection == null || connection.isNull()) {
            throw nullField(field);
        }
        return PageReader.read(connection, recorded, itemReader);
    }

    private <T> List<T> parseAll(final String field, final JsonNode value, final ScalarType<T> type) {
        if (!value.isArray()) {
            throw notAList(field);
        }
        return value.valueStream()
                .filter(element -> !element.isNull())
                .map(element -> parse(field, element, type))
                .toList();
    }

    private <T> T parse(final String field, final JsonNode value, final ScalarType<T> type) {
        try {
            return type.read(value);
        } catch (final IllegalArgumentException failure) {
            throw new IllegalStateException(
                    FIELD_PREFIX + selection.path() + "." + field + " has an " + failure.getMessage(), failure);
        }
    }

    private IllegalStateException notAList(final String field) {
        return new IllegalStateException(
                FIELD_PREFIX + selection.path() + "." + field + " is not a list in the response");
    }

    private IllegalStateException nullField(final String field) {
        return new IllegalStateException(
                "non-null field " + selection.path() + "." + field + " is null in the response");
    }

    private FieldSelection requireRecorded(final String field) {
        final FieldSelection recorded = selection.child(field);
        if (recorded == null) {
            throw new IllegalStateException(FIELD_PREFIX + selection.path() + "." + field
                    + " was not requested by the recording pass: the lambda must not branch on values it reads");
        }
        return recorded;
    }
}
