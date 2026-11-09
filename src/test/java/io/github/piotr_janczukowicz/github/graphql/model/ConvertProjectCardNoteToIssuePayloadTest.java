package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ConvertProjectCardNoteToIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenProjectCardIdIsNull() {
        final ConvertProjectCardNoteToIssuePayloadBuilder builder =
                ConvertProjectCardNoteToIssuePayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectCardId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final ConvertProjectCardNoteToIssuePayloadBuilder builder =
                ConvertProjectCardNoteToIssuePayloadBuilder.builder().projectCardId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ConvertProjectCardNoteToIssuePayload input = ConvertProjectCardNoteToIssuePayloadBuilder.builder()
                .projectCardId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectCardId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ConvertProjectCardNoteToIssuePayload input = ConvertProjectCardNoteToIssuePayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .projectCardId("x")
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("projectCardId", "x"),
                        entry("repositoryId", "x"),
                        entry("title", "x"));
    }
}
