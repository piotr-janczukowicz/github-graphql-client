package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddProjectV2ItemByIdPayloadTest {

    @Test
    void constructor_shouldFail_whenContentIdIsNull() {
        final AddProjectV2ItemByIdPayloadBuilder builder =
                AddProjectV2ItemByIdPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("contentId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final AddProjectV2ItemByIdPayloadBuilder builder =
                AddProjectV2ItemByIdPayloadBuilder.builder().contentId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddProjectV2ItemByIdPayload input = AddProjectV2ItemByIdPayloadBuilder.builder()
                .contentId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("contentId", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddProjectV2ItemByIdPayload input = AddProjectV2ItemByIdPayloadBuilder.builder()
                .clientMutationId("x")
                .contentId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("contentId", "x"), entry("projectId", "x"));
    }
}
