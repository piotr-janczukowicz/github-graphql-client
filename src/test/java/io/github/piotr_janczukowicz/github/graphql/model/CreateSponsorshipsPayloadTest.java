package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateSponsorshipsPayloadTest {

    @Test
    void constructor_shouldFail_whenSponsorLoginIsNull() {
        final CreateSponsorshipsPayloadBuilder builder = CreateSponsorshipsPayloadBuilder.builder()
                .sponsorships(List.of(BulkSponsorshipBuilder.builder().amount(1).build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sponsorLogin must not be null");
    }

    @Test
    void constructor_shouldFail_whenSponsorshipsIsNull() {
        final CreateSponsorshipsPayloadBuilder builder =
                CreateSponsorshipsPayloadBuilder.builder().sponsorLogin("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sponsorships must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateSponsorshipsPayload input = CreateSponsorshipsPayloadBuilder.builder()
                .sponsorLogin("x")
                .sponsorships(List.of(BulkSponsorshipBuilder.builder().amount(1).build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("sponsorLogin", "x"), entry("sponsorships", List.of(Map.ofEntries(entry("amount", 1)))));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateSponsorshipsPayload input = CreateSponsorshipsPayloadBuilder.builder()
                .clientMutationId("x")
                .privacyLevel(SponsorshipPrivacy.PRIVATE)
                .receiveEmails(true)
                .recurring(true)
                .sponsorLogin("x")
                .sponsorships(List.of(BulkSponsorshipBuilder.builder().amount(1).build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("privacyLevel", "PRIVATE"),
                        entry("receiveEmails", true),
                        entry("recurring", true),
                        entry("sponsorLogin", "x"),
                        entry("sponsorships", List.of(Map.ofEntries(entry("amount", 1)))));
    }
}
