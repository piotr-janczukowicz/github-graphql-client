package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CancelSponsorshipPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CancelSponsorshipPayload input =
                CancelSponsorshipPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CancelSponsorshipPayload input = CancelSponsorshipPayloadBuilder.builder()
                .clientMutationId("x")
                .sponsorId("x")
                .sponsorLogin("x")
                .sponsorableId("x")
                .sponsorableLogin("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("sponsorId", "x"),
                        entry("sponsorLogin", "x"),
                        entry("sponsorableId", "x"),
                        entry("sponsorableLogin", "x"));
    }
}
