package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitHubGraphQLExceptionTest {

    private static final GraphQLError FIRST = new GraphQLError("first problem", List.of("repository"));
    private static final GraphQLError SECOND = new GraphQLError("second problem", List.of());

    @Test
    void constructor_shouldUseTheMessageOfTheError_whenThereIsOneError() {
        final List<GraphQLError> errors = List.of(FIRST);

        final GitHubGraphQLException exception = new GitHubGraphQLException(errors);

        assertSoftly(softly -> {
            softly.assertThat(exception).hasMessage("first problem");
            softly.assertThat(exception.errors()).containsExactly(FIRST);
        });
    }

    @Test
    void constructor_shouldCountTheOtherErrors_whenThereAreSeveralErrors() {
        final List<GraphQLError> errors = List.of(FIRST, SECOND);

        final GitHubGraphQLException exception = new GitHubGraphQLException(errors);

        assertSoftly(softly -> {
            softly.assertThat(exception).hasMessage("first problem (and 1 more)");
            softly.assertThat(exception.errors()).containsExactly(FIRST, SECOND);
        });
    }
}
