package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.github.client.GitHubCaller;
import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.pagination.PaginationConfiguration;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class GitHubGraphQLTest {

    @Test
    void of_shouldFail_whenTheCallerIsNull() {
        final GitHubCaller caller = null;

        final Throwable thrown = catchThrowable(() -> GitHubGraphQL.of(caller));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("caller must not be null");
    }

    @Test
    void of_shouldFail_whenTheCallerIsNullAndAPaginationIsGiven() {
        final GitHubCaller caller = null;
        final PaginationConfiguration pagination = PaginationConfiguration.defaults();

        final Throwable thrown = catchThrowable(() -> GitHubGraphQL.of(caller, pagination));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("caller must not be null");
    }

    @Test
    void of_shouldFail_whenTheClientIsNull() {
        final GitHubClient client = null;

        final Throwable thrown = catchThrowable(() -> GitHubGraphQL.of(client));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("client must not be null");
    }
}
