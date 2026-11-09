package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ClearProjectV2ItemFieldValuePayloadTest {

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final ClearProjectV2ItemFieldValuePayloadBuilder builder =
                ClearProjectV2ItemFieldValuePayloadBuilder.builder().itemId("x").projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final ClearProjectV2ItemFieldValuePayloadBuilder builder = ClearProjectV2ItemFieldValuePayloadBuilder.builder()
                .fieldId("x")
                .projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final ClearProjectV2ItemFieldValuePayloadBuilder builder = ClearProjectV2ItemFieldValuePayloadBuilder.builder()
                .fieldId("x")
                .itemId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ClearProjectV2ItemFieldValuePayload input = ClearProjectV2ItemFieldValuePayloadBuilder.builder()
                .fieldId("x")
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldId", "x"), entry("itemId", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ClearProjectV2ItemFieldValuePayload input = ClearProjectV2ItemFieldValuePayloadBuilder.builder()
                .clientMutationId("x")
                .fieldId("x")
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("fieldId", "x"),
                        entry("itemId", "x"),
                        entry("projectId", "x"));
    }
}
