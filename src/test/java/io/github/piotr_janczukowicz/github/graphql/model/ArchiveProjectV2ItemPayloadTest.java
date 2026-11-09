package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ArchiveProjectV2ItemPayloadTest {

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final ArchiveProjectV2ItemPayloadBuilder builder =
                ArchiveProjectV2ItemPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final ArchiveProjectV2ItemPayloadBuilder builder =
                ArchiveProjectV2ItemPayloadBuilder.builder().itemId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ArchiveProjectV2ItemPayload input = ArchiveProjectV2ItemPayloadBuilder.builder()
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("itemId", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ArchiveProjectV2ItemPayload input = ArchiveProjectV2ItemPayloadBuilder.builder()
                .clientMutationId("x")
                .itemId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("itemId", "x"), entry("projectId", "x"));
    }
}
