package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateIssueFieldPayloadTest {

    private static final String NAME = "name";

    @Test
    void constructor_shouldFail_whenDataTypeIsNull() {
        final CreateIssueFieldPayloadBuilder builder =
                CreateIssueFieldPayloadBuilder.builder().name("x").ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("dataType must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateIssueFieldPayloadBuilder builder = CreateIssueFieldPayloadBuilder.builder()
                .dataType(IssueFieldDataType.DATE)
                .ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CreateIssueFieldPayloadBuilder builder = CreateIssueFieldPayloadBuilder.builder()
                .dataType(IssueFieldDataType.DATE)
                .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateIssueFieldPayload input = CreateIssueFieldPayloadBuilder.builder()
                .dataType(IssueFieldDataType.DATE)
                .name("x")
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("dataType", "DATE"), entry(NAME, "x"), entry("ownerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateIssueFieldPayload input = CreateIssueFieldPayloadBuilder.builder()
                .clientMutationId("x")
                .dataType(IssueFieldDataType.DATE)
                .description("x")
                .name("x")
                .options(List.of(IssueFieldSingleSelectOptionInputBuilder.builder()
                        .color(IssueFieldSingleSelectOptionColor.BLUE)
                        .name("x")
                        .priority(1)
                        .build()))
                .ownerId("x")
                .visibility(IssueFieldVisibility.ALL)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("dataType", "DATE"),
                        entry("description", "x"),
                        entry(NAME, "x"),
                        entry(
                                "options",
                                List.of(Map.ofEntries(entry("color", "BLUE"), entry(NAME, "x"), entry("priority", 1)))),
                        entry("ownerId", "x"),
                        entry("visibility", "ALL"));
    }
}
