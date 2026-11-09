package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateCommitOnBranchPayloadTest {

    @Test
    void constructor_shouldFail_whenBranchIsNull() {
        final CreateCommitOnBranchPayloadBuilder builder = CreateCommitOnBranchPayloadBuilder.builder()
                .expectedHeadOid("x")
                .message(CommitMessageBuilder.builder().headline("x").build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("branch must not be null");
    }

    @Test
    void constructor_shouldFail_whenExpectedHeadOidIsNull() {
        final CreateCommitOnBranchPayloadBuilder builder = CreateCommitOnBranchPayloadBuilder.builder()
                .branch(CommittableBranchBuilder.builder().build())
                .message(CommitMessageBuilder.builder().headline("x").build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("expectedHeadOid must not be null");
    }

    @Test
    void constructor_shouldFail_whenMessageIsNull() {
        final CreateCommitOnBranchPayloadBuilder builder = CreateCommitOnBranchPayloadBuilder.builder()
                .branch(CommittableBranchBuilder.builder().build())
                .expectedHeadOid("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("message must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateCommitOnBranchPayload input = CreateCommitOnBranchPayloadBuilder.builder()
                .branch(CommittableBranchBuilder.builder().build())
                .expectedHeadOid("x")
                .message(CommitMessageBuilder.builder().headline("x").build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("branch", Map.ofEntries()),
                        entry("expectedHeadOid", "x"),
                        entry("message", Map.ofEntries(entry("headline", "x"))));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateCommitOnBranchPayload input = CreateCommitOnBranchPayloadBuilder.builder()
                .branch(CommittableBranchBuilder.builder().build())
                .clientMutationId("x")
                .expectedHeadOid("x")
                .fileChanges(FileChangesBuilder.builder().build())
                .message(CommitMessageBuilder.builder().headline("x").build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("branch", Map.ofEntries()),
                        entry("clientMutationId", "x"),
                        entry("expectedHeadOid", "x"),
                        entry("fileChanges", Map.ofEntries()),
                        entry("message", Map.ofEntries(entry("headline", "x"))));
    }
}
