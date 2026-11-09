package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.json.OptionalNull;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

@UnitTest
class CustomPropertyValueInputTest {

    private static final String VALUE = "value";

    @Test
    void constructor_shouldFail_whenPropertyNameIsNull() {
        final CustomPropertyValueInputBuilder builder = CustomPropertyValueInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("propertyName must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CustomPropertyValueInput input =
                CustomPropertyValueInputBuilder.builder().propertyName("x").build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("propertyName", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CustomPropertyValueInput input = CustomPropertyValueInputBuilder.builder()
                .propertyName("x")
                .value(OptionalNull.of(CustomPropertyValue.ofText("x")))
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("propertyName", "x"), entry(VALUE, "x"));
    }

    @Test
    void toVariable_shouldSendNull_whenValueIsExplicitlyNull() {
        final CustomPropertyValueInput input = CustomPropertyValueInputBuilder.builder()
                .propertyName("x")
                .value(OptionalNull.ofNull())
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry(VALUE, null);
    }

    @Test
    void toVariable_shouldSendTheList_whenValueIsAList() {
        final CustomPropertyValueInput input = CustomPropertyValueInputBuilder.builder()
                .propertyName("x")
                .value(OptionalNull.of(CustomPropertyValue.ofOptions(List.of("x"))))
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry(VALUE, List.of("x"));
    }
}
