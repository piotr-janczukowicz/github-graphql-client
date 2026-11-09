package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SecurityAdvisoryIdentifierFilterTest {

    @Test
    void constructor_shouldFail_whenTypeIsNull() {
        final SecurityAdvisoryIdentifierFilterBuilder builder =
                SecurityAdvisoryIdentifierFilterBuilder.builder().value("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("type must not be null");
    }

    @Test
    void constructor_shouldFail_whenValueIsNull() {
        final SecurityAdvisoryIdentifierFilterBuilder builder =
                SecurityAdvisoryIdentifierFilterBuilder.builder().type(SecurityAdvisoryIdentifierType.CVE);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SecurityAdvisoryIdentifierFilter input = SecurityAdvisoryIdentifierFilterBuilder.builder()
                .type(SecurityAdvisoryIdentifierType.CVE)
                .value("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("type", "CVE"), entry("value", "x"));
    }
}
