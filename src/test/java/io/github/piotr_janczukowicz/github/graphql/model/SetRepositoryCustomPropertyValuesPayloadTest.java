package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SetRepositoryCustomPropertyValuesPayloadTest {

    @Test
    void constructor_shouldFail_whenPropertiesIsNull() {
        final SetRepositoryCustomPropertyValuesPayloadBuilder builder =
                SetRepositoryCustomPropertyValuesPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("properties must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final SetRepositoryCustomPropertyValuesPayloadBuilder builder =
                SetRepositoryCustomPropertyValuesPayloadBuilder.builder()
                        .properties(List.of(CustomPropertyValueInputBuilder.builder()
                                .propertyName("x")
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SetRepositoryCustomPropertyValuesPayload input = SetRepositoryCustomPropertyValuesPayloadBuilder.builder()
                .properties(List.of(CustomPropertyValueInputBuilder.builder()
                        .propertyName("x")
                        .build()))
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("properties", List.of(Map.ofEntries(entry("propertyName", "x")))),
                        entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SetRepositoryCustomPropertyValuesPayload input = SetRepositoryCustomPropertyValuesPayloadBuilder.builder()
                .clientMutationId("x")
                .properties(List.of(CustomPropertyValueInputBuilder.builder()
                        .propertyName("x")
                        .build()))
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("properties", List.of(Map.ofEntries(entry("propertyName", "x")))),
                        entry("repositoryId", "x"));
    }
}
