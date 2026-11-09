package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AcceptEnterpriseMemberInvitationPayloadTest {

    @Test
    void constructor_shouldFail_whenInvitationIdIsNull() {
        final AcceptEnterpriseMemberInvitationPayloadBuilder builder =
                AcceptEnterpriseMemberInvitationPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("invitationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AcceptEnterpriseMemberInvitationPayload input = AcceptEnterpriseMemberInvitationPayloadBuilder.builder()
                .invitationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("invitationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AcceptEnterpriseMemberInvitationPayload input = AcceptEnterpriseMemberInvitationPayloadBuilder.builder()
                .clientMutationId("x")
                .invitationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("invitationId", "x"));
    }
}
