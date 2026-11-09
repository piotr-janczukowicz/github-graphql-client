package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateEnterpriseOrganizationPayloadTest {

    @Test
    void constructor_shouldFail_whenAdminLoginsIsNull() {
        final CreateEnterpriseOrganizationPayloadBuilder builder = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .billingEmail("x")
                .enterpriseId("x")
                .login("x")
                .profileName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("adminLogins must not be null");
    }

    @Test
    void constructor_shouldFail_whenBillingEmailIsNull() {
        final CreateEnterpriseOrganizationPayloadBuilder builder = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .enterpriseId("x")
                .login("x")
                .profileName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("billingEmail must not be null");
    }

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final CreateEnterpriseOrganizationPayloadBuilder builder = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .billingEmail("x")
                .login("x")
                .profileName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenLoginIsNull() {
        final CreateEnterpriseOrganizationPayloadBuilder builder = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .billingEmail("x")
                .enterpriseId("x")
                .profileName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("login must not be null");
    }

    @Test
    void constructor_shouldFail_whenProfileNameIsNull() {
        final CreateEnterpriseOrganizationPayloadBuilder builder = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .billingEmail("x")
                .enterpriseId("x")
                .login("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("profileName must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateEnterpriseOrganizationPayload input = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .billingEmail("x")
                .enterpriseId("x")
                .login("x")
                .profileName("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("adminLogins", List.of("x")),
                        entry("billingEmail", "x"),
                        entry("enterpriseId", "x"),
                        entry("login", "x"),
                        entry("profileName", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateEnterpriseOrganizationPayload input = CreateEnterpriseOrganizationPayloadBuilder.builder()
                .adminLogins(List.of("x"))
                .billingEmail("x")
                .clientMutationId("x")
                .enterpriseId("x")
                .login("x")
                .profileName("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("adminLogins", List.of("x")),
                        entry("billingEmail", "x"),
                        entry("clientMutationId", "x"),
                        entry("enterpriseId", "x"),
                        entry("login", "x"),
                        entry("profileName", "x"));
    }
}
