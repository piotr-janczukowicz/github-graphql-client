package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateRefsPayloadTest {

    @Test
    void constructor_shouldFail_whenRefUpdatesIsNull() {
        final UpdateRefsPayloadBuilder builder =
                UpdateRefsPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("refUpdates must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UpdateRefsPayloadBuilder builder = UpdateRefsPayloadBuilder.builder()
                .refUpdates(List.of(
                        RefUpdateBuilder.builder().afterOid("x").name("x").build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateRefsPayload input = UpdateRefsPayloadBuilder.builder()
                .refUpdates(List.of(
                        RefUpdateBuilder.builder().afterOid("x").name("x").build()))
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("refUpdates", List.of(Map.ofEntries(entry("afterOid", "x"), entry("name", "x")))),
                        entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateRefsPayload input = UpdateRefsPayloadBuilder.builder()
                .clientMutationId("x")
                .refUpdates(List.of(
                        RefUpdateBuilder.builder().afterOid("x").name("x").build()))
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("refUpdates", List.of(Map.ofEntries(entry("afterOid", "x"), entry("name", "x")))),
                        entry("repositoryId", "x"));
    }
}
