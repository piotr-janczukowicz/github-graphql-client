package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnlinkProjectV2FromRepositoryPayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UnlinkProjectV2FromRepositoryPayloadBuilder builder =
                UnlinkProjectV2FromRepositoryPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UnlinkProjectV2FromRepositoryPayloadBuilder builder =
                UnlinkProjectV2FromRepositoryPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnlinkProjectV2FromRepositoryPayload input = UnlinkProjectV2FromRepositoryPayloadBuilder.builder()
                .projectId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnlinkProjectV2FromRepositoryPayload input = UnlinkProjectV2FromRepositoryPayloadBuilder.builder()
                .clientMutationId("x")
                .projectId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("projectId", "x"), entry("repositoryId", "x"));
    }
}
