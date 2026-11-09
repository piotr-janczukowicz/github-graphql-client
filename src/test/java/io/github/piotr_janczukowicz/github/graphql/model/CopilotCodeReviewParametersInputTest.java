package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CopilotCodeReviewParametersInputTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CopilotCodeReviewParametersInput input =
                CopilotCodeReviewParametersInputBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CopilotCodeReviewParametersInput input = CopilotCodeReviewParametersInputBuilder.builder()
                .reviewDraftPullRequests(true)
                .reviewOnPush(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("reviewDraftPullRequests", true), entry("reviewOnPush", true));
    }
}
