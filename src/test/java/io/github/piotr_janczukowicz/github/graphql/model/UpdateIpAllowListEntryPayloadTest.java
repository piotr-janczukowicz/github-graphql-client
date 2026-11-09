package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateIpAllowListEntryPayloadTest {

    @Test
    void constructor_shouldFail_whenAllowListValueIsNull() {
        final UpdateIpAllowListEntryPayloadBuilder builder = UpdateIpAllowListEntryPayloadBuilder.builder()
                .ipAllowListEntryId("x")
                .isActive(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("allowListValue must not be null");
    }

    @Test
    void constructor_shouldFail_whenIpAllowListEntryIdIsNull() {
        final UpdateIpAllowListEntryPayloadBuilder builder = UpdateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .isActive(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ipAllowListEntryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenIsActiveIsNull() {
        final UpdateIpAllowListEntryPayloadBuilder builder = UpdateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .ipAllowListEntryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("isActive must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateIpAllowListEntryPayload input = UpdateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .ipAllowListEntryId("x")
                .isActive(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowListValue", "x"), entry("ipAllowListEntryId", "x"), entry("isActive", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateIpAllowListEntryPayload input = UpdateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .clientMutationId("x")
                .ipAllowListEntryId("x")
                .isActive(true)
                .name("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowListValue", "x"),
                        entry("clientMutationId", "x"),
                        entry("ipAllowListEntryId", "x"),
                        entry("isActive", true),
                        entry("name", "x"));
    }
}
