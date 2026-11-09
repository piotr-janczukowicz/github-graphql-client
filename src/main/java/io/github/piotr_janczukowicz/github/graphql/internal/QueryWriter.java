package io.github.piotr_janczukowicz.github.graphql.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

final class QueryWriter {

    private final Map<String, Object> variables = new LinkedHashMap<>();
    private final List<String> definitions = new ArrayList<>();

    private QueryWriter() {}

    static QueryDocument write(final FieldSelection root) {
        final QueryWriter writer = new QueryWriter();
        final String selectionSet = writer.selectionSet(root);
        final String operation = root.name();
        final String header =
                writer.definitions.isEmpty() ? operation : operation + "(" + String.join(",", writer.definitions) + ")";
        return new QueryDocument(header + selectionSet, writer.variables);
    }

    private String selectionSet(final FieldSelection parent) {
        final StringJoiner fields = new StringJoiner(" ", "{", "}");
        for (final FieldSelection child : parent.children()) {
            fields.add(field(child));
        }
        return fields.toString();
    }

    private String field(final FieldSelection selection) {
        final StringJoiner arguments = new StringJoiner(",", "(", ")");
        arguments.setEmptyValue("");
        for (final Argument argument : selection.arguments()) {
            final Object value = argument.value();
            if (value != null) {
                arguments.add(argument.name() + ":$" + variable(argument, value));
            }
        }
        final String children = selection.isEmpty() ? "" : selectionSet(selection);
        return selection.name() + arguments + children;
    }

    private String variable(final Argument argument, final Object value) {
        String name = argument.name();
        int suffix = 2;
        while (variables.containsKey(name)) {
            name = argument.name() + suffix;
            suffix++;
        }
        variables.put(name, value);
        definitions.add("$" + name + ":" + argument.graphqlType());
        return name;
    }
}
