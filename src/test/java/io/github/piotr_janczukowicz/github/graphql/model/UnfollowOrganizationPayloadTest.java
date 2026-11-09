package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnfollowOrganizationPayloadTest {

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UnfollowOrganizationPayloadBuilder builder = UnfollowOrganizationPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnfollowOrganizationPayload input =
                UnfollowOrganizationPayloadBuilder.builder().organizationId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("organizationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnfollowOrganizationPayload input = UnfollowOrganizationPayloadBuilder.builder()
                .clientMutationId("x")
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("organizationId", "x"));
    }
}
