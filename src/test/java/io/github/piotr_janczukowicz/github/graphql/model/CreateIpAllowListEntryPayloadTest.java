package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateIpAllowListEntryPayloadTest {

    @Test
    void constructor_shouldFail_whenAllowListValueIsNull() {
        final CreateIpAllowListEntryPayloadBuilder builder =
                CreateIpAllowListEntryPayloadBuilder.builder().isActive(true).ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("allowListValue must not be null");
    }

    @Test
    void constructor_shouldFail_whenIsActiveIsNull() {
        final CreateIpAllowListEntryPayloadBuilder builder = CreateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("isActive must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CreateIpAllowListEntryPayloadBuilder builder = CreateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .isActive(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateIpAllowListEntryPayload input = CreateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .isActive(true)
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("allowListValue", "x"), entry("isActive", true), entry("ownerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateIpAllowListEntryPayload input = CreateIpAllowListEntryPayloadBuilder.builder()
                .allowListValue("x")
                .clientMutationId("x")
                .isActive(true)
                .name("x")
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowListValue", "x"),
                        entry("clientMutationId", "x"),
                        entry("isActive", true),
                        entry("name", "x"),
                        entry("ownerId", "x"));
    }
}
