package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ConvertProjectV2DraftIssueItemToIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final ConvertProjectV2DraftIssueItemToIssuePayloadBuilder builder =
                ConvertProjectV2DraftIssueItemToIssuePayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final ConvertProjectV2DraftIssueItemToIssuePayloadBuilder builder =
                ConvertProjectV2DraftIssueItemToIssuePayloadBuilder.builder().itemId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ConvertProjectV2DraftIssueItemToIssuePayload input =
                ConvertProjectV2DraftIssueItemToIssuePayloadBuilder.builder()
                        .itemId("x")
                        .repositoryId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("itemId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ConvertProjectV2DraftIssueItemToIssuePayload input =
                ConvertProjectV2DraftIssueItemToIssuePayloadBuilder.builder()
                        .clientMutationId("x")
                        .itemId("x")
                        .repositoryId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("itemId", "x"), entry("repositoryId", "x"));
    }
}
