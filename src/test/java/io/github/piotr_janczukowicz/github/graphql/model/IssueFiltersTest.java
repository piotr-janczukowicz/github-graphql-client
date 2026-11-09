package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueFiltersTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final IssueFilters input = IssueFiltersBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final IssueFilters input = IssueFiltersBuilder.builder()
                .assignee("x")
                .createdBy("x")
                .issueFieldValues(List.of(IssueFieldValueFilterBuilder.builder().build()))
                .labels(List.of("x"))
                .mentioned("x")
                .milestone("x")
                .milestoneNumber("x")
                .since(Instant.parse("2024-05-01T10:15:30Z"))
                .states(List.of(IssueState.CLOSED))
                .type("x")
                .viewerSubscribed(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("assignee", "x"),
                        entry("createdBy", "x"),
                        entry("issueFieldValues", List.of(Map.ofEntries())),
                        entry("labels", List.of("x")),
                        entry("mentioned", "x"),
                        entry("milestone", "x"),
                        entry("milestoneNumber", "x"),
                        entry("since", "2024-05-01T10:15:30Z"),
                        entry("states", List.of("CLOSED")),
                        entry("type", "x"),
                        entry("viewerSubscribed", true));
    }
}
