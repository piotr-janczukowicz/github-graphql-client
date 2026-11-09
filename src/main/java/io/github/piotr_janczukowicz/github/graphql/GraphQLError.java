package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;

/**
 * One entry of the {@code errors} list of a GraphQL response.
 *
 * @param message the error message
 * @param path the path of the field that failed, as field names and list indexes written as numbers; empty when GitHub
 *     gives none
 */
public record GraphQLError(String message, List<String> path) {

    public GraphQLError {
        requireNonNull(message, "message");
        path = ListUtils.copyOf(path, "path");
    }
}
