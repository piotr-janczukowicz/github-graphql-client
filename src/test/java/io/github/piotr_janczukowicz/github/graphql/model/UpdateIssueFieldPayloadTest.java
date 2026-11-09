package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIssueFieldPayloadTest {

    @Test
    void constructor_shouldFail_whenIdIsNull() {
        final UpdateIssueFieldPayloadBuilder builder = UpdateIssueFieldPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("id must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIssueFieldPayload input =
                UpdateIssueFieldPayloadBuilder.builder().id("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("id", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIssueFieldPayload input = UpdateIssueFieldPayloadBuilder.builder()
                .clientMutationId("x")
                .description("x")
                .id("x")
                .name("x")
                .options(List.of(IssueFieldSingleSelectOptionInputBuilder.builder()
                        .color(IssueFieldSingleSelectOptionColor.BLUE)
                        .name("x")
                        .priority(1)
                        .build()))
                .visibility(IssueFieldVisibility.ALL)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("id", "x"),
                        entry("name", "x"),
                        entry(
                                "options",
                                List.of(Map.ofEntries(
                                        entry("color", "BLUE"), entry("name", "x"), entry("priority", 1)))),
                        entry("visibility", "ALL"));
    }
}
