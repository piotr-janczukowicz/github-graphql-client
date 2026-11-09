package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateRepositoryCustomPropertyPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryCustomPropertyIdIsNull() {
        final UpdateRepositoryCustomPropertyPayloadBuilder builder =
                UpdateRepositoryCustomPropertyPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("repositoryCustomPropertyId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateRepositoryCustomPropertyPayload input = UpdateRepositoryCustomPropertyPayloadBuilder.builder()
                .repositoryCustomPropertyId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryCustomPropertyId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateRepositoryCustomPropertyPayload input = UpdateRepositoryCustomPropertyPayloadBuilder.builder()
                .allowedValues(List.of("x"))
                .clientMutationId("x")
                .defaultValue("x")
                .description("x")
                .regex("x")
                .repositoryCustomPropertyId("x")
                .requireExplicitValues(true)
                .required(true)
                .valuesEditableBy(RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowedValues", List.of("x")),
                        entry("clientMutationId", "x"),
                        entry("defaultValue", "x"),
                        entry("description", "x"),
                        entry("regex", "x"),
                        entry("repositoryCustomPropertyId", "x"),
                        entry("requireExplicitValues", true),
                        entry("required", true),
                        entry("valuesEditableBy", "ORG_ACTORS"));
    }
}
