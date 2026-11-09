package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RetireSponsorsTierPayloadTest {

    @Test
    void constructor_shouldFail_whenTierIdIsNull() {
        final RetireSponsorsTierPayloadBuilder builder = RetireSponsorsTierPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("tierId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RetireSponsorsTierPayload input =
                RetireSponsorsTierPayloadBuilder.builder().tierId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("tierId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RetireSponsorsTierPayload input = RetireSponsorsTierPayloadBuilder.builder()
                .clientMutationId("x")
                .tierId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("tierId", "x"));
    }
}
