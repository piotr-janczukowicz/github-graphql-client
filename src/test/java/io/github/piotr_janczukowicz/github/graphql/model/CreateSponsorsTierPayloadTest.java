package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateSponsorsTierPayloadTest {

    @Test
    void constructor_shouldFail_whenAmountIsNull() {
        final CreateSponsorsTierPayloadBuilder builder =
                CreateSponsorsTierPayloadBuilder.builder().description("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("amount must not be null");
    }

    @Test
    void constructor_shouldFail_whenDescriptionIsNull() {
        final CreateSponsorsTierPayloadBuilder builder =
                CreateSponsorsTierPayloadBuilder.builder().amount(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("description must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateSponsorsTierPayload input = CreateSponsorsTierPayloadBuilder.builder()
                .amount(1)
                .description("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("amount", 1), entry("description", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateSponsorsTierPayload input = CreateSponsorsTierPayloadBuilder.builder()
                .amount(1)
                .clientMutationId("x")
                .description("x")
                .isRecurring(true)
                .publish(true)
                .repositoryId("x")
                .repositoryName("x")
                .repositoryOwnerLogin("x")
                .sponsorableId("x")
                .sponsorableLogin("x")
                .welcomeMessage("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("amount", 1),
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("isRecurring", true),
                        entry("publish", true),
                        entry("repositoryId", "x"),
                        entry("repositoryName", "x"),
                        entry("repositoryOwnerLogin", "x"),
                        entry("sponsorableId", "x"),
                        entry("sponsorableLogin", "x"),
                        entry("welcomeMessage", "x"));
    }
}
