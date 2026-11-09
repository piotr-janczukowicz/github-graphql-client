package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateSponsorshipPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateSponsorshipPayload input =
                CreateSponsorshipPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateSponsorshipPayload input = CreateSponsorshipPayloadBuilder.builder()
                .amount(1)
                .clientMutationId("x")
                .isRecurring(true)
                .privacyLevel(SponsorshipPrivacy.PRIVATE)
                .receiveEmails(true)
                .sponsorId("x")
                .sponsorLogin("x")
                .sponsorableId("x")
                .sponsorableLogin("x")
                .tierId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("amount", 1),
                        entry("clientMutationId", "x"),
                        entry("isRecurring", true),
                        entry("privacyLevel", "PRIVATE"),
                        entry("receiveEmails", true),
                        entry("sponsorId", "x"),
                        entry("sponsorLogin", "x"),
                        entry("sponsorableId", "x"),
                        entry("sponsorableLogin", "x"),
                        entry("tierId", "x"));
    }
}
