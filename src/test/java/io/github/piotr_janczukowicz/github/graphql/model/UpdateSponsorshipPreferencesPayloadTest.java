package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateSponsorshipPreferencesPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateSponsorshipPreferencesPayload input =
                UpdateSponsorshipPreferencesPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateSponsorshipPreferencesPayload input = UpdateSponsorshipPreferencesPayloadBuilder.builder()
                .clientMutationId("x")
                .privacyLevel(SponsorshipPrivacy.PRIVATE)
                .receiveEmails(true)
                .sponsorId("x")
                .sponsorLogin("x")
                .sponsorableId("x")
                .sponsorableLogin("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("privacyLevel", "PRIVATE"),
                        entry("receiveEmails", true),
                        entry("sponsorId", "x"),
                        entry("sponsorLogin", "x"),
                        entry("sponsorableId", "x"),
                        entry("sponsorableLogin", "x"));
    }
}
