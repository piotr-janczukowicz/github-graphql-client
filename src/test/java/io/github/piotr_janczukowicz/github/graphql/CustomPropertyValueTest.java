package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class CustomPropertyValueTest {

    @Test
    void ofText_shouldKeepTheTextAndNoOptions_whenTheValueIsAString() {
        final CustomPropertyValue value = CustomPropertyValue.ofText("high");

        assertSoftly(softly -> {
            softly.assertThat(value.text()).isEqualTo("high");
            softly.assertThat(value.options()).isNull();
        });
    }

    @Test
    void ofOptions_shouldKeepTheOptionsAndNoText_whenTheValueIsAList() {
        final CustomPropertyValue value = CustomPropertyValue.ofOptions(List.of("a", "b"));

        assertSoftly(softly -> {
            softly.assertThat(value.options()).containsExactly("a", "b");
            softly.assertThat(value.text()).isNull();
        });
    }

    @Test
    void ofOptions_shouldCopyTheList_whenTheSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("a"));

        final CustomPropertyValue value = CustomPropertyValue.ofOptions(source);
        source.add("b");

        assertThat(value.options()).containsExactly("a");
    }

    @Test
    void ofOptions_shouldRejectANullElement_whenTheListHasOne() {
        final List<String> options = Arrays.asList("a", null);

        final Throwable thrown = catchThrowable(() -> CustomPropertyValue.ofOptions(options));

        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void ofText_shouldFailNamingTheArgument_whenTheTextIsNull() {
        final Throwable thrown = catchThrowable(() -> CustomPropertyValue.ofText(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("text must not be null");
    }

    @Test
    void equals_shouldCompareTheShapeAndTheContent_whenTwoValuesAreCompared() {
        final CustomPropertyValue text = CustomPropertyValue.ofText("a");
        final CustomPropertyValue options = CustomPropertyValue.ofOptions(List.of("a"));

        assertSoftly(softly -> {
            softly.assertThat(text)
                    .isEqualTo(CustomPropertyValue.ofText("a"))
                    .hasSameHashCodeAs(CustomPropertyValue.ofText("a"));
            softly.assertThat(text).isNotEqualTo(options).isNotEqualTo("a");
            softly.assertThat(options).isEqualTo(CustomPropertyValue.ofOptions(List.of("a")));
            softly.assertThat(text.toString()).contains("a");
            softly.assertThat(options.toString()).contains("[a]");
        });
    }

    @Test
    void equals_shouldBeFalse_whenTheTextOrTheOptionsDiffer() {
        final CustomPropertyValue text = CustomPropertyValue.ofText("a");
        final CustomPropertyValue options = CustomPropertyValue.ofOptions(List.of("a"));

        assertSoftly(softly -> {
            softly.assertThat(text).isNotEqualTo(CustomPropertyValue.ofText("b"));
            softly.assertThat(options).isNotEqualTo(CustomPropertyValue.ofOptions(List.of("b")));
            softly.assertThat(options).isNotEqualTo(text);
            softly.assertThat(text).isNotEqualTo(null);
        });
    }
}
