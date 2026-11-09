package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateLinkedBranchPayloadTest {

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final CreateLinkedBranchPayloadBuilder builder =
                CreateLinkedBranchPayloadBuilder.builder().oid("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void constructor_shouldFail_whenOidIsNull() {
        final CreateLinkedBranchPayloadBuilder builder =
                CreateLinkedBranchPayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("oid must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateLinkedBranchPayload input =
                CreateLinkedBranchPayloadBuilder.builder().issueId("x").oid("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueId", "x"), entry("oid", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateLinkedBranchPayload input = CreateLinkedBranchPayloadBuilder.builder()
                .clientMutationId("x")
                .issueId("x")
                .name("x")
                .oid("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("issueId", "x"),
                        entry("name", "x"),
                        entry("oid", "x"),
                        entry("repositoryId", "x"));
    }
}
