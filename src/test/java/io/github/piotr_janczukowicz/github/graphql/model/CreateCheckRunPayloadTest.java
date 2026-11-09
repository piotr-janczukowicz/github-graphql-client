package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateCheckRunPayloadTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    @Test
    void constructor_shouldFail_whenHeadShaIsNull() {
        final CreateCheckRunPayloadBuilder builder =
                CreateCheckRunPayloadBuilder.builder().name("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("headSha must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateCheckRunPayloadBuilder builder =
                CreateCheckRunPayloadBuilder.builder().headSha("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateCheckRunPayloadBuilder builder =
                CreateCheckRunPayloadBuilder.builder().headSha("x").name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateCheckRunPayload input = CreateCheckRunPayloadBuilder.builder()
                .headSha("x")
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("headSha", "x"), entry("name", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateCheckRunPayload input = CreateCheckRunPayloadBuilder.builder()
                .actions(List.of(CheckRunActionBuilder.builder()
                        .description("x")
                        .identifier("x")
                        .label("x")
                        .build()))
                .clientMutationId("x")
                .completedAt(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                .conclusion(CheckConclusionState.ACTION_REQUIRED)
                .detailsUrl("x")
                .externalId("x")
                .headSha("x")
                .name("x")
                .output(CheckRunOutputBuilder.builder().summary("x").title("x").build())
                .repositoryId("x")
                .startedAt(Instant.parse(VALUE_2024_05_01_T10_15_30_Z))
                .status(RequestableCheckStatusState.COMPLETED)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "actions",
                                List.of(Map.ofEntries(
                                        entry("description", "x"), entry("identifier", "x"), entry("label", "x")))),
                        entry("clientMutationId", "x"),
                        entry("completedAt", VALUE_2024_05_01_T10_15_30_Z),
                        entry("conclusion", "ACTION_REQUIRED"),
                        entry("detailsUrl", "x"),
                        entry("externalId", "x"),
                        entry("headSha", "x"),
                        entry("name", "x"),
                        entry("output", Map.ofEntries(entry("summary", "x"), entry("title", "x"))),
                        entry("repositoryId", "x"),
                        entry("startedAt", VALUE_2024_05_01_T10_15_30_Z),
                        entry("status", "COMPLETED"));
    }
}
