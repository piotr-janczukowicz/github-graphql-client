package io.github.piotr_janczukowicz.github.graphql.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A GraphQL operation ready to send.
 *
 * @param text the query text, with every argument value as a variable
 * @param variables the variable values by name, in the order of the query
 */
public record QueryDocument(String text, Map<String, Object> variables) {

    public QueryDocument {
        variables = Collections.unmodifiableMap(new LinkedHashMap<>(variables));
    }
}
