package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RerequestCheckSuitePayloadTest {

    @Test
    void constructor_shouldFail_whenCheckSuiteIdIsNull() {
        final RerequestCheckSuitePayloadBuilder builder =
                RerequestCheckSuitePayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("checkSuiteId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final RerequestCheckSuitePayloadBuilder builder =
                RerequestCheckSuitePayloadBuilder.builder().checkSuiteId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RerequestCheckSuitePayload input = RerequestCheckSuitePayloadBuilder.builder()
                .checkSuiteId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("checkSuiteId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RerequestCheckSuitePayload input = RerequestCheckSuitePayloadBuilder.builder()
                .checkSuiteId("x")
                .clientMutationId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("checkSuiteId", "x"), entry("clientMutationId", "x"), entry("repositoryId", "x"));
    }
}
