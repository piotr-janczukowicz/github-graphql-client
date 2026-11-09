package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class TransferEnterpriseOrganizationPayloadTest {

    @Test
    void constructor_shouldFail_whenDestinationEnterpriseIdIsNull() {
        final TransferEnterpriseOrganizationPayloadBuilder builder =
                TransferEnterpriseOrganizationPayloadBuilder.builder().organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("destinationEnterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final TransferEnterpriseOrganizationPayloadBuilder builder =
                TransferEnterpriseOrganizationPayloadBuilder.builder().destinationEnterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final TransferEnterpriseOrganizationPayload input = TransferEnterpriseOrganizationPayloadBuilder.builder()
                .destinationEnterpriseId("x")
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("destinationEnterpriseId", "x"), entry("organizationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final TransferEnterpriseOrganizationPayload input = TransferEnterpriseOrganizationPayloadBuilder.builder()
                .clientMutationId("x")
                .destinationEnterpriseId("x")
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("destinationEnterpriseId", "x"),
                        entry("organizationId", "x"));
    }
}
