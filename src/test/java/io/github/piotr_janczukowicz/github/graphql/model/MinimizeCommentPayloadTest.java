package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class MinimizeCommentPayloadTest {

    @Test
    void constructor_shouldFail_whenClassifierIsNull() {
        final MinimizeCommentPayloadBuilder builder =
                MinimizeCommentPayloadBuilder.builder().subjectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("classifier must not be null");
    }

    @Test
    void constructor_shouldFail_whenSubjectIdIsNull() {
        final MinimizeCommentPayloadBuilder builder =
                MinimizeCommentPayloadBuilder.builder().classifier(ReportedContentClassifiers.ABUSE);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("subjectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MinimizeCommentPayload input = MinimizeCommentPayloadBuilder.builder()
                .classifier(ReportedContentClassifiers.ABUSE)
                .subjectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("classifier", "ABUSE"), entry("subjectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MinimizeCommentPayload input = MinimizeCommentPayloadBuilder.builder()
                .classifier(ReportedContentClassifiers.ABUSE)
                .clientMutationId("x")
                .subjectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("classifier", "ABUSE"), entry("clientMutationId", "x"), entry("subjectId", "x"));
    }
}
