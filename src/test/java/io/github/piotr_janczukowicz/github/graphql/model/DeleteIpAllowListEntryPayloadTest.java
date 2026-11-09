package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteIpAllowListEntryPayloadTest {

    @Test
    void constructor_shouldFail_whenIpAllowListEntryIdIsNull() {
        final DeleteIpAllowListEntryPayloadBuilder builder = DeleteIpAllowListEntryPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ipAllowListEntryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteIpAllowListEntryPayload input = DeleteIpAllowListEntryPayloadBuilder.builder()
                .ipAllowListEntryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ipAllowListEntryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteIpAllowListEntryPayload input = DeleteIpAllowListEntryPayloadBuilder.builder()
                .clientMutationId("x")
                .ipAllowListEntryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("ipAllowListEntryId", "x"));
    }
}
