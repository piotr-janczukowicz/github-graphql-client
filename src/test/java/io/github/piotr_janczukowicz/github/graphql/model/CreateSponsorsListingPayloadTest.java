package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateSponsorsListingPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateSponsorsListingPayload input =
                CreateSponsorsListingPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateSponsorsListingPayload input = CreateSponsorsListingPayloadBuilder.builder()
                .billingCountryOrRegionCode(SponsorsCountryOrRegionCode.AD)
                .clientMutationId("x")
                .contactEmail("x")
                .fiscalHostLogin("x")
                .fiscallyHostedProjectProfileUrl("x")
                .fullDescription("x")
                .residenceCountryOrRegionCode(SponsorsCountryOrRegionCode.AD)
                .sponsorableLogin("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("billingCountryOrRegionCode", "AD"),
                        entry("clientMutationId", "x"),
                        entry("contactEmail", "x"),
                        entry("fiscalHostLogin", "x"),
                        entry("fiscallyHostedProjectProfileUrl", "x"),
                        entry("fullDescription", "x"),
                        entry("residenceCountryOrRegionCode", "AD"),
                        entry("sponsorableLogin", "x"));
    }
}
