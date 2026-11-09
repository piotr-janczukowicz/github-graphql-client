package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RequiredReviewerConfigurationInputTest {

    @Test
    void constructor_shouldFail_whenFilePatternsIsNull() {
        final RequiredReviewerConfigurationInputBuilder builder = RequiredReviewerConfigurationInputBuilder.builder()
                .minimumApprovals(1)
                .reviewerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("filePatterns must not be null");
    }

    @Test
    void constructor_shouldFail_whenMinimumApprovalsIsNull() {
        final RequiredReviewerConfigurationInputBuilder builder = RequiredReviewerConfigurationInputBuilder.builder()
                .filePatterns(List.of("x"))
                .reviewerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("minimumApprovals must not be null");
    }

    @Test
    void constructor_shouldFail_whenReviewerIdIsNull() {
        final RequiredReviewerConfigurationInputBuilder builder = RequiredReviewerConfigurationInputBuilder.builder()
                .filePatterns(List.of("x"))
                .minimumApprovals(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("reviewerId must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RequiredReviewerConfigurationInput input = RequiredReviewerConfigurationInputBuilder.builder()
                .filePatterns(List.of("x"))
                .minimumApprovals(1)
                .reviewerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("filePatterns", List.of("x")), entry("minimumApprovals", 1), entry("reviewerId", "x"));
    }
}
