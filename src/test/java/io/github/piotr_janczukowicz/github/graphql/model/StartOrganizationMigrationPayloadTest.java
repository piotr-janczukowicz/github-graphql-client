package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class StartOrganizationMigrationPayloadTest {

    @Test
    void constructor_shouldFail_whenSourceAccessTokenIsNull() {
        final StartOrganizationMigrationPayloadBuilder builder = StartOrganizationMigrationPayloadBuilder.builder()
                .sourceOrgUrl("x")
                .targetEnterpriseId("x")
                .targetOrgName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceAccessToken must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceOrgUrlIsNull() {
        final StartOrganizationMigrationPayloadBuilder builder = StartOrganizationMigrationPayloadBuilder.builder()
                .sourceAccessToken("x")
                .targetEnterpriseId("x")
                .targetOrgName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceOrgUrl must not be null");
    }

    @Test
    void constructor_shouldFail_whenTargetEnterpriseIdIsNull() {
        final StartOrganizationMigrationPayloadBuilder builder = StartOrganizationMigrationPayloadBuilder.builder()
                .sourceAccessToken("x")
                .sourceOrgUrl("x")
                .targetOrgName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("targetEnterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTargetOrgNameIsNull() {
        final StartOrganizationMigrationPayloadBuilder builder = StartOrganizationMigrationPayloadBuilder.builder()
                .sourceAccessToken("x")
                .sourceOrgUrl("x")
                .targetEnterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("targetOrgName must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final StartOrganizationMigrationPayload input = StartOrganizationMigrationPayloadBuilder.builder()
                .sourceAccessToken("x")
                .sourceOrgUrl("x")
                .targetEnterpriseId("x")
                .targetOrgName("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("sourceAccessToken", "x"),
                        entry("sourceOrgUrl", "x"),
                        entry("targetEnterpriseId", "x"),
                        entry("targetOrgName", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final StartOrganizationMigrationPayload input = StartOrganizationMigrationPayloadBuilder.builder()
                .clientMutationId("x")
                .sourceAccessToken("x")
                .sourceOrgUrl("x")
                .targetEnterpriseId("x")
                .targetOrgName("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("sourceAccessToken", "x"),
                        entry("sourceOrgUrl", "x"),
                        entry("targetEnterpriseId", "x"),
                        entry("targetOrgName", "x"));
    }
}
