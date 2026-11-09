package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateRepositoryCustomPropertyPayloadTest {

    @Test
    void constructor_shouldFail_whenPropertyNameIsNull() {
        final CreateRepositoryCustomPropertyPayloadBuilder builder =
                CreateRepositoryCustomPropertyPayloadBuilder.builder()
                        .sourceId("x")
                        .valueType(CustomPropertyValueType.MULTI_SELECT);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("propertyName must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceIdIsNull() {
        final CreateRepositoryCustomPropertyPayloadBuilder builder =
                CreateRepositoryCustomPropertyPayloadBuilder.builder()
                        .propertyName("x")
                        .valueType(CustomPropertyValueType.MULTI_SELECT);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceId must not be null");
    }

    @Test
    void constructor_shouldFail_whenValueTypeIsNull() {
        final CreateRepositoryCustomPropertyPayloadBuilder builder =
                CreateRepositoryCustomPropertyPayloadBuilder.builder()
                        .propertyName("x")
                        .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("valueType must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateRepositoryCustomPropertyPayload input = CreateRepositoryCustomPropertyPayloadBuilder.builder()
                .propertyName("x")
                .sourceId("x")
                .valueType(CustomPropertyValueType.MULTI_SELECT)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("propertyName", "x"), entry("sourceId", "x"), entry("valueType", "MULTI_SELECT"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateRepositoryCustomPropertyPayload input = CreateRepositoryCustomPropertyPayloadBuilder.builder()
                .allowedValues(List.of("x"))
                .clientMutationId("x")
                .defaultValue("x")
                .description("x")
                .propertyName("x")
                .regex("x")
                .requireExplicitValues(true)
                .required(true)
                .sourceId("x")
                .valueType(CustomPropertyValueType.MULTI_SELECT)
                .valuesEditableBy(RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowedValues", List.of("x")),
                        entry("clientMutationId", "x"),
                        entry("defaultValue", "x"),
                        entry("description", "x"),
                        entry("propertyName", "x"),
                        entry("regex", "x"),
                        entry("requireExplicitValues", true),
                        entry("required", true),
                        entry("sourceId", "x"),
                        entry("valueType", "MULTI_SELECT"),
                        entry("valuesEditableBy", "ORG_ACTORS"));
    }
}
