package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeBranchPayloadTest {

    @Test
    void constructor_shouldFail_whenBaseIsNull() {
        final MergeBranchPayloadBuilder builder =
                MergeBranchPayloadBuilder.builder().head("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("base must not be null");
    }

    @Test
    void constructor_shouldFail_whenHeadIsNull() {
        final MergeBranchPayloadBuilder builder =
                MergeBranchPayloadBuilder.builder().base("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("head must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final MergeBranchPayloadBuilder builder =
                MergeBranchPayloadBuilder.builder().base("x").head("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MergeBranchPayload input = MergeBranchPayloadBuilder.builder()
                .base("x")
                .head("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("base", "x"), entry("head", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MergeBranchPayload input = MergeBranchPayloadBuilder.builder()
                .authorEmail("x")
                .base("x")
                .clientMutationId("x")
                .commitMessage("x")
                .head("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("authorEmail", "x"),
                        entry("base", "x"),
                        entry("clientMutationId", "x"),
                        entry("commitMessage", "x"),
                        entry("head", "x"),
                        entry("repositoryId", "x"));
    }
}
