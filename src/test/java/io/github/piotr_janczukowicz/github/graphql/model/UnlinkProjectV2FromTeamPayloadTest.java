package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnlinkProjectV2FromTeamPayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UnlinkProjectV2FromTeamPayloadBuilder builder =
                UnlinkProjectV2FromTeamPayloadBuilder.builder().teamId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTeamIdIsNull() {
        final UnlinkProjectV2FromTeamPayloadBuilder builder =
                UnlinkProjectV2FromTeamPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("teamId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnlinkProjectV2FromTeamPayload input = UnlinkProjectV2FromTeamPayloadBuilder.builder()
                .projectId("x")
                .teamId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"), entry("teamId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnlinkProjectV2FromTeamPayload input = UnlinkProjectV2FromTeamPayloadBuilder.builder()
                .clientMutationId("x")
                .projectId("x")
                .teamId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("projectId", "x"), entry("teamId", "x"));
    }
}
