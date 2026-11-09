package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class InviteEnterpriseMemberPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final InviteEnterpriseMemberPayloadBuilder builder = InviteEnterpriseMemberPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final InviteEnterpriseMemberPayload input =
                InviteEnterpriseMemberPayloadBuilder.builder().enterpriseId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final InviteEnterpriseMemberPayload input = InviteEnterpriseMemberPayloadBuilder.builder()
                .clientMutationId("x")
                .email("x")
                .enterpriseId("x")
                .invitee("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("email", "x"),
                        entry("enterpriseId", "x"),
                        entry("invitee", "x"));
    }
}
