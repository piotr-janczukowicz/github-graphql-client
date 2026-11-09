package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdatePatreonSponsorabilityPayloadTest {

    @Test
    void constructor_shouldFail_whenEnablePatreonSponsorshipsIsNull() {
        final UpdatePatreonSponsorabilityPayloadBuilder builder = UpdatePatreonSponsorabilityPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("enablePatreonSponsorships must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdatePatreonSponsorabilityPayload input = UpdatePatreonSponsorabilityPayloadBuilder.builder()
                .enablePatreonSponsorships(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enablePatreonSponsorships", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdatePatreonSponsorabilityPayload input = UpdatePatreonSponsorabilityPayloadBuilder.builder()
                .clientMutationId("x")
                .enablePatreonSponsorships(true)
                .sponsorableLogin("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("enablePatreonSponsorships", true),
                        entry("sponsorableLogin", "x"));
    }
}
