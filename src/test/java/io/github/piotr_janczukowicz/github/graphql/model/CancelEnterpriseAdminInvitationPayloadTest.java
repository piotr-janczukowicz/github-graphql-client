package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CancelEnterpriseAdminInvitationPayloadTest {

    @Test
    void constructor_shouldFail_whenInvitationIdIsNull() {
        final CancelEnterpriseAdminInvitationPayloadBuilder builder =
                CancelEnterpriseAdminInvitationPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("invitationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CancelEnterpriseAdminInvitationPayload input = CancelEnterpriseAdminInvitationPayloadBuilder.builder()
                .invitationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("invitationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CancelEnterpriseAdminInvitationPayload input = CancelEnterpriseAdminInvitationPayloadBuilder.builder()
                .clientMutationId("x")
                .invitationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("invitationId", "x"));
    }
}
