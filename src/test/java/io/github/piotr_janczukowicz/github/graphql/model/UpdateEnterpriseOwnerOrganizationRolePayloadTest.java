package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseOwnerOrganizationRolePayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseOwnerOrganizationRolePayloadBuilder builder =
                UpdateEnterpriseOwnerOrganizationRolePayloadBuilder.builder()
                        .organizationId("x")
                        .organizationRole(RoleInOrganization.DIRECT_MEMBER);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UpdateEnterpriseOwnerOrganizationRolePayloadBuilder builder =
                UpdateEnterpriseOwnerOrganizationRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .organizationRole(RoleInOrganization.DIRECT_MEMBER);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void constructor_shouldFail_whenOrganizationRoleIsNull() {
        final UpdateEnterpriseOwnerOrganizationRolePayloadBuilder builder =
                UpdateEnterpriseOwnerOrganizationRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationRole must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseOwnerOrganizationRolePayload input =
                UpdateEnterpriseOwnerOrganizationRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .organizationId("x")
                        .organizationRole(RoleInOrganization.DIRECT_MEMBER)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("enterpriseId", "x"),
                        entry("organizationId", "x"),
                        entry("organizationRole", "DIRECT_MEMBER"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseOwnerOrganizationRolePayload input =
                UpdateEnterpriseOwnerOrganizationRolePayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .organizationId("x")
                        .organizationRole(RoleInOrganization.DIRECT_MEMBER)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("enterpriseId", "x"),
                        entry("organizationId", "x"),
                        entry("organizationRole", "DIRECT_MEMBER"));
    }
}
