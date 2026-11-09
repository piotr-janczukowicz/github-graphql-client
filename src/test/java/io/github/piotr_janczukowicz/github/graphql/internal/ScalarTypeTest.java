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
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ScalarTypeTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();
    private static final ScalarType<IssueState> STATE =
            ScalarType.enumeration(IssueState::fromWire, IssueState.UNRECOGNIZED);

    @Test
    void enumeration_shouldReturnTheConstant_whenTheWireValueIsKnown() {
        final IssueState state = STATE.read(MAPPER.readTree("\"OPEN\""));

        assertThat(state).isEqualTo(IssueState.OPEN);
    }

    @Test
    void enumeration_shouldReturnTheFallback_whenTheWireValueIsUnknown() {
        final IssueState state = STATE.read(MAPPER.readTree("\"DRAFT\""));

        assertThat(state).isEqualTo(IssueState.UNRECOGNIZED);
    }

    @Test
    void instant_shouldParseAnIsoString_whenTheValueIsADateTime() {
        final Instant instant = ScalarType.INSTANT.read(MAPPER.readTree("\"2024-05-01T10:15:30Z\""));

        assertThat(instant).isEqualTo(Instant.parse("2024-05-01T10:15:30Z"));
    }

    @Test
    void localDate_shouldParseAnIsoDate_whenTheValueIsADate() {
        final LocalDate date = ScalarType.LOCAL_DATE.read(MAPPER.readTree("\"2024-05-01\""));

        assertThat(date).isEqualTo(LocalDate.of(2024, 5, 1));
    }

    @Test
    void bigInteger_shouldParseADecimalString_whenTheValueIsABigInt() {
        final BigInteger number = ScalarType.BIG_INTEGER.read(MAPPER.readTree("\"12345678901234567890\""));

        assertThat(number).isEqualTo(new BigInteger("12345678901234567890"));
    }

    @Test
    void offsetDateTime_shouldKeepTheOffset_whenTheValueIsAGitTimestamp() {
        final OffsetDateTime time = ScalarType.OFFSET_DATE_TIME.read(MAPPER.readTree("\"2024-05-01T10:15:30+02:00\""));

        assertThat(time.getOffset()).isEqualTo(ZoneOffset.ofHours(2));
    }

    @Test
    void placeholder_shouldBeANonNullValueOfTheType_whenRecording() {
        assertSoftly(softly -> {
            softly.assertThat(ScalarType.INSTANT.placeholder()).isEqualTo(Instant.EPOCH);
            softly.assertThat(ScalarType.LOCAL_DATE.placeholder()).isEqualTo(LocalDate.EPOCH);
            softly.assertThat(ScalarType.BIG_INTEGER.placeholder()).isEqualTo(BigInteger.ZERO);
            softly.assertThat(ScalarType.OFFSET_DATE_TIME.placeholder())
                    .isEqualTo(Instant.EPOCH.atOffset(ZoneOffset.UTC));
        });
    }

    @Test
    void enumeration_shouldUseThePlaceholder_whenRecording() {
        final IssueState placeholder = STATE.placeholder();

        assertThat(placeholder).isEqualTo(IssueState.UNRECOGNIZED);
    }

    @Test
    void customPropertyValue_shouldReadAString_whenTheValueIsText() {
        final CustomPropertyValue value = ScalarType.CUSTOM_PROPERTY_VALUE.read(MAPPER.readTree("\"high\""));

        assertThat(value).isEqualTo(CustomPropertyValue.ofText("high"));
    }

    @Test
    void customPropertyValue_shouldReadAnArray_whenTheValueIsAListOfStrings() {
        final CustomPropertyValue value = ScalarType.CUSTOM_PROPERTY_VALUE.read(MAPPER.readTree("[\"a\",\"b\"]"));

        assertThat(value).isEqualTo(CustomPropertyValue.ofOptions(List.of("a", "b")));
    }

    @Test
    void customPropertyValue_shouldFail_whenTheValueIsANumber() {
        final JsonNode number = MAPPER.readTree("5");

        final Throwable thrown = catchThrowable(() -> ScalarType.CUSTOM_PROPERTY_VALUE.read(number));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("CustomPropertyValue");
    }

    @Test
    void customPropertyValue_shouldFail_whenAnArrayElementIsNotAString() {
        final JsonNode array = MAPPER.readTree("[\"a\",1]");

        final Throwable thrown = catchThrowable(() -> ScalarType.CUSTOM_PROPERTY_VALUE.read(array));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("CustomPropertyValue");
    }

    @Test
    void customPropertyValue_shouldHaveATextPlaceholder_whenRecording() {
        final CustomPropertyValue placeholder = ScalarType.CUSTOM_PROPERTY_VALUE.placeholder();

        assertThat(placeholder).isEqualTo(CustomPropertyValue.ofText(""));
    }
}
