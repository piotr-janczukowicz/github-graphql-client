package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateTeamReviewAssignmentPayloadTest {

    @Test
    void constructor_shouldFail_whenEnabledIsNull() {
        final UpdateTeamReviewAssignmentPayloadBuilder builder =
                UpdateTeamReviewAssignmentPayloadBuilder.builder().id("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enabled must not be null");
    }

    @Test
    void constructor_shouldFail_whenIdIsNull() {
        final UpdateTeamReviewAssignmentPayloadBuilder builder =
                UpdateTeamReviewAssignmentPayloadBuilder.builder().enabled(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("id must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateTeamReviewAssignmentPayload input = UpdateTeamReviewAssignmentPayloadBuilder.builder()
                .enabled(true)
                .id("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enabled", true), entry("id", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateTeamReviewAssignmentPayload input = UpdateTeamReviewAssignmentPayloadBuilder.builder()
                .algorithm(TeamReviewAssignmentAlgorithm.LOAD_BALANCE)
                .clientMutationId("x")
                .countMembersAlreadyRequested(true)
                .enabled(true)
                .excludedTeamMemberIds(List.of("x"))
                .id("x")
                .includeChildTeamMembers(true)
                .notifyTeam(true)
                .removeTeamRequest(true)
                .teamMemberCount(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("algorithm", "LOAD_BALANCE"),
                        entry("clientMutationId", "x"),
                        entry("countMembersAlreadyRequested", true),
                        entry("enabled", true),
                        entry("excludedTeamMemberIds", List.of("x")),
                        entry("id", "x"),
                        entry("includeChildTeamMembers", true),
                        entry("notifyTeam", true),
                        entry("removeTeamRequest", true),
                        entry("teamMemberCount", 1));
    }
}
