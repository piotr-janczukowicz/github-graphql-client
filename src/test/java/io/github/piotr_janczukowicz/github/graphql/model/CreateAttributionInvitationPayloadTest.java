package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateAttributionInvitationPayloadTest {

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CreateAttributionInvitationPayloadBuilder builder = CreateAttributionInvitationPayloadBuilder.builder()
                .sourceId("x")
                .targetId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceIdIsNull() {
        final CreateAttributionInvitationPayloadBuilder builder =
                CreateAttributionInvitationPayloadBuilder.builder().ownerId("x").targetId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTargetIdIsNull() {
        final CreateAttributionInvitationPayloadBuilder builder =
                CreateAttributionInvitationPayloadBuilder.builder().ownerId("x").sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("targetId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateAttributionInvitationPayload input = CreateAttributionInvitationPayloadBuilder.builder()
                .ownerId("x")
                .sourceId("x")
                .targetId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ownerId", "x"), entry("sourceId", "x"), entry("targetId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateAttributionInvitationPayload input = CreateAttributionInvitationPayloadBuilder.builder()
                .clientMutationId("x")
                .ownerId("x")
                .sourceId("x")
                .targetId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("ownerId", "x"),
                        entry("sourceId", "x"),
                        entry("targetId", "x"));
    }
}
