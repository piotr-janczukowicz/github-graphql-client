package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class ArgumentTest {

    @Test
    void of_shouldUseTheNameOfTheConstant_whenTheValueIsAnEnum() {
        final Argument argument = Argument.of("state", "IssueState", IssueState.OPEN);

        assertThat(argument.value()).isEqualTo("OPEN");
    }

    @Test
    void of_shouldReject_whenTheEnumIsUnrecognized() {
        final Throwable thrown = catchThrowable(() -> Argument.of("states", "IssueState", IssueState.UNRECOGNIZED));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("states");
    }

    @Test
    void of_shouldMapAListOfEnumsToNames_whenTheValueIsAList() {
        final Argument argument = Argument.of("states", "[IssueState!]", List.of(IssueState.OPEN, IssueState.CLOSED));

        assertThat(argument.value()).isEqualTo(List.of("OPEN", "CLOSED"));
    }

    @Test
    void of_shouldReject_whenAListHasANullElement() {
        final List<String> labels = Arrays.asList("bug", null);

        final Throwable thrown = catchThrowable(() -> Argument.of("labels", "[String!]", labels));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("labels");
    }

    @Test
    void of_shouldReject_whenAListContainsAnUnrecognizedEnum() {
        final List<IssueState> states = List.of(IssueState.OPEN, IssueState.UNRECOGNIZED);

        final Throwable thrown = catchThrowable(() -> Argument.of("states", "[IssueState!]", states));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("states");
    }

    @Test
    void of_shouldKeepAnEmptyListAndNull_whenTheValuesAreEmptyOrAbsent() {
        final Argument empty = Argument.of("states", "[IssueState!]", List.of());
        final Argument absent = Argument.of("states", "[IssueState!]", null);

        assertSoftly(softly -> {
            softly.assertThat(empty.value()).isEqualTo(List.of());
            softly.assertThat(absent.value()).isNull();
        });
    }

    @Test
    void of_shouldWriteDatesAndBigIntegersAsText_whenTheValuesAreCustomScalars() {
        final Argument instant = Argument.of("since", "DateTime", Instant.parse("2024-05-01T10:15:30Z"));
        final Argument date = Argument.of("on", "Date", LocalDate.of(2024, 5, 1));
        final Argument time =
                Argument.of("at", "GitTimestamp", OffsetDateTime.of(2024, 5, 1, 10, 15, 30, 0, ZoneOffset.ofHours(2)));
        final Argument number = Argument.of("size", "BigInt", new BigInteger("12345678901234567890"));

        assertSoftly(softly -> {
            softly.assertThat(instant.value()).isEqualTo("2024-05-01T10:15:30Z");
            softly.assertThat(date.value()).isEqualTo("2024-05-01");
            softly.assertThat(time.value()).isEqualTo("2024-05-01T10:15:30+02:00");
            softly.assertThat(number.value()).isEqualTo("12345678901234567890");
        });
    }

    @Test
    void of_shouldKeepOtherValues_whenTheValueIsAStringOrANumber() {
        final Argument text = Argument.of("name", "String", "x");
        final Argument number = Argument.of("first", "Int", 5);

        assertSoftly(softly -> {
            softly.assertThat(text.value()).isEqualTo("x");
            softly.assertThat(number.value()).isEqualTo(5);
        });
    }

    @Test
    void of_shouldWriteTheTextOrTheOptions_whenTheValueIsACustomPropertyValue() {
        final Argument text = Argument.of("value", "CustomPropertyValue", CustomPropertyValue.ofText("core"));
        final Argument options =
                Argument.of("value", "CustomPropertyValue", CustomPropertyValue.ofOptions(List.of("a", "b")));

        assertSoftly(softly -> {
            softly.assertThat(text.value()).isEqualTo("core");
            softly.assertThat(options.value()).isEqualTo(List.of("a", "b"));
        });
    }
}
