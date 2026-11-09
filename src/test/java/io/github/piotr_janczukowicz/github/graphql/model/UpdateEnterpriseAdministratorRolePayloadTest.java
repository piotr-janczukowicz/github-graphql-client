package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseAdministratorRolePayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseAdministratorRolePayloadBuilder builder =
                UpdateEnterpriseAdministratorRolePayloadBuilder.builder()
                        .login("x")
                        .role(EnterpriseAdministratorRole.BILLING_MANAGER);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenLoginIsNull() {
        final UpdateEnterpriseAdministratorRolePayloadBuilder builder =
                UpdateEnterpriseAdministratorRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .role(EnterpriseAdministratorRole.BILLING_MANAGER);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("login must not be null");
    }

    @Test
    void constructor_shouldFail_whenRoleIsNull() {
        final UpdateEnterpriseAdministratorRolePayloadBuilder builder =
                UpdateEnterpriseAdministratorRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .login("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("role must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseAdministratorRolePayload input = UpdateEnterpriseAdministratorRolePayloadBuilder.builder()
                .enterpriseId("x")
                .login("x")
                .role(EnterpriseAdministratorRole.BILLING_MANAGER)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("enterpriseId", "x"), entry("login", "x"), entry("role", "BILLING_MANAGER"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseAdministratorRolePayload input = UpdateEnterpriseAdministratorRolePayloadBuilder.builder()
                .clientMutationId("x")
                .enterpriseId("x")
                .login("x")
                .role(EnterpriseAdministratorRole.BILLING_MANAGER)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("enterpriseId", "x"),
                        entry("login", "x"),
                        entry("role", "BILLING_MANAGER"));
    }
}
