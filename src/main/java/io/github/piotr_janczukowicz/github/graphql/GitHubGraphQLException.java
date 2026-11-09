package io.github.piotr_janczukowicz.github.graphql;

import java.io.Serial;
import java.util.List;

/**
 * GitHub answered a GraphQL request with a non-empty {@code errors} list. The query fails as a whole, even when GitHub
 * also returned partial data.
 */
public final class GitHubGraphQLException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final transient List<GraphQLError> errors;

    /**
     * Creates the exception.
     *
     * @param errors the errors of the response, at least one
     */
    public GitHubGraphQLException(final List<GraphQLError> errors) {
        super(describe(errors));
        this.errors = List.copyOf(errors);
    }

    /**
     * Returns the errors of the response.
     *
     * @return the errors, in the order GitHub sent them
     */
    public List<GraphQLError> errors() {
        return errors;
    }

    private static String describe(final List<GraphQLError> errors) {
        final String first = errors.getFirst().message();
        return errors.size() == 1 ? first : first + " (and " + (errors.size() - 1) + " more)";
    }
}
