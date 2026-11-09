package io.github.piotr_janczukowicz.github.graphql.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

final class FieldSelection {

    private final String name;
    private final String path;
    private final List<Argument> arguments;
    private final Map<String, FieldSelection> children = new LinkedHashMap<>();

    private FieldSelection(final String name, final String path, final List<Argument> arguments) {
        this.name = name;
        this.path = path;
        this.arguments = arguments;
    }

    static FieldSelection root() {
        return root("query");
    }

    static FieldSelection root(final String operation) {
        return new FieldSelection(operation, operation, List.of());
    }

    static String fragmentName(final String typeName) {
        return "... on " + typeName;
    }

    FieldSelection select(final String field, final List<Argument> fieldArguments) {
        final FieldSelection existing = children.get(field);
        if (existing == null) {
            final FieldSelection created = new FieldSelection(field, path + "." + field, fieldArguments);
            children.put(field, created);
            return created;
        }
        if (!existing.arguments.equals(fieldArguments)) {
            throw new IllegalStateException("field " + existing.path
                    + " is selected twice with different arguments; aliases are not supported (a connection can be read"
                    + " with either the plain method or the Paging method in one query, not with both)");
        }
        return existing;
    }

    @Nullable FieldSelection child(final String field) {
        return children.get(field);
    }

    String name() {
        return name;
    }

    String path() {
        return path;
    }

    List<Argument> arguments() {
        return arguments;
    }

    Iterable<FieldSelection> children() {
        return children.values();
    }

    boolean isEmpty() {
        return children.isEmpty();
    }
}
