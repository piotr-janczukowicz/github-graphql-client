package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GrantEnterpriseOrganizationsMigratorRolePayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final GrantEnterpriseOrganizationsMigratorRolePayloadBuilder builder =
                GrantEnterpriseOrganizationsMigratorRolePayloadBuilder.builder().login("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenLoginIsNull() {
        final GrantEnterpriseOrganizationsMigratorRolePayloadBuilder builder =
                GrantEnterpriseOrganizationsMigratorRolePayloadBuilder.builder().enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("login must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final GrantEnterpriseOrganizationsMigratorRolePayload input =
                GrantEnterpriseOrganizationsMigratorRolePayloadBuilder.builder()
                        .enterpriseId("x")
                        .login("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"), entry("login", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final GrantEnterpriseOrganizationsMigratorRolePayload input =
                GrantEnterpriseOrganizationsMigratorRolePayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .login("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("enterpriseId", "x"), entry("login", "x"));
    }
}
