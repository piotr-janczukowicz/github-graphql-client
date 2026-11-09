package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class BulkSponsorshipTest {

    @Test
    void constructor_shouldFail_whenAmountIsNull() {
        final BulkSponsorshipBuilder builder = BulkSponsorshipBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("amount must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final BulkSponsorship input = BulkSponsorshipBuilder.builder().amount(1).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("amount", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final BulkSponsorship input = BulkSponsorshipBuilder.builder()
                .amount(1)
                .sponsorableId("x")
                .sponsorableLogin("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("amount", 1), entry("sponsorableId", "x"), entry("sponsorableLogin", "x"));
    }
}
