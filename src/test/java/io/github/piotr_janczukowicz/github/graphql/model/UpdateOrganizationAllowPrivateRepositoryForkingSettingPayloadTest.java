package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenForkingEnabledIsNull() {
        final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder builder =
                UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder.builder()
                        .organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("forkingEnabled must not be null");
    }

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder builder =
                UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder.builder()
                        .forkingEnabled(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayload input =
                UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder.builder()
                        .forkingEnabled(true)
                        .organizationId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("forkingEnabled", true), entry("organizationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateOrganizationAllowPrivateRepositoryForkingSettingPayload input =
                UpdateOrganizationAllowPrivateRepositoryForkingSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .forkingEnabled(true)
                        .organizationId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("forkingEnabled", true), entry("organizationId", "x"));
    }
}
