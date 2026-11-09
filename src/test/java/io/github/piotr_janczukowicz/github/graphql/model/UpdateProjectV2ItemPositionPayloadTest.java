package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.json.OptionalNull;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2ItemPositionPayloadTest {

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final UpdateProjectV2ItemPositionPayloadBuilder builder =
                UpdateProjectV2ItemPositionPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UpdateProjectV2ItemPositionPayloadBuilder builder =
                UpdateProjectV2ItemPositionPayloadBuilder.builder().itemId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2ItemPositionPayload input = UpdateProjectV2ItemPositionPayloadBuilder.builder()
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("itemId", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2ItemPositionPayload input = UpdateProjectV2ItemPositionPayloadBuilder.builder()
                .afterId(OptionalNull.of("x"))
                .clientMutationId("x")
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("afterId", "x"),
                        entry("clientMutationId", "x"),
                        entry("itemId", "x"),
                        entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldSendNull_whenAfterIdIsExplicitlyNull() {
        final UpdateProjectV2ItemPositionPayload input = UpdateProjectV2ItemPositionPayloadBuilder.builder()
                .itemId("x")
                .projectId("x")
                .afterId(OptionalNull.ofNull())
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry("afterId", null);
    }
}
