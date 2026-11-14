package io.github.piotr_janczukowicz.github.graphql.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.GitHubGraphQL;
import io.github.piotr_janczukowicz.github.graphql.GitHubGraphQLException;
import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SearchType;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class ViewerSmokeIT {

    private static SmokeSupport smoke;

    record Limit(int limit, int remaining, int cost) {}

    @BeforeAll
    static void connect() {
        smoke = SmokeSupport.connect();
    }

    @AfterAll
    static void disconnect() {
        if (smoke != null) {
            smoke.close();
        }
    }

    @Test
    void query_shouldReadTheViewer_whenTheTokenIsValid() throws IOException {
        final String login = smoke.graphql().query(query -> query.viewer(UserSelector::login));

        assertThat(login).isEqualToIgnoringCase(smoke.owner());
    }

    @Test
    void query_shouldReportTheRateLimit_whenReadingTheBudget() throws IOException {
        final Limit limit = smoke.graphql()
                .query(query ->
                        query.rateLimit(budget -> new Limit(budget.limit(), budget.remaining(), budget.cost())));

        assertSoftly(softly -> {
            softly.assertThat(limit.limit()).isPositive();
            softly.assertThat(limit.remaining()).isBetween(0, limit.limit());
            softly.assertThat(limit.cost()).isPositive();
        });
    }

    @Test
    void query_shouldRaiseTheGraphQLErrors_whenTheRepositoryDoesNotExist() {
        final GitHubGraphQL graphql = smoke.graphql();
        final String missing = smoke.name("missing");

        final Throwable thrown = catchThrowable(
                () -> graphql.query(query -> query.repository(missing, smoke.owner(), RepositorySelector::id)));

        assertThat(thrown)
                .isInstanceOfSatisfying(
                        GitHubGraphQLException.class,
                        exception -> assertThat(exception.errors()).isNotEmpty());
    }

    @Test
    void search_shouldFindTheSandbox_whenSearchingRepositoriesByName() throws IOException {
        final Page<String> page = smoke.graphql()
                .query(query -> query.search(
                        "repo:" + smoke.owner() + "/" + smoke.repo(),
                        SearchType.REPOSITORY,
                        Paging.first(1),
                        item -> item.on(RepositorySelector.class, RepositorySelector::name)));

        assertThat(page.items()).containsExactly(smoke.repo());
    }
}
