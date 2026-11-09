package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateUserListsForItemPayloadTest {

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final UpdateUserListsForItemPayloadBuilder builder =
                UpdateUserListsForItemPayloadBuilder.builder().listIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenListIdsIsNull() {
        final UpdateUserListsForItemPayloadBuilder builder =
                UpdateUserListsForItemPayloadBuilder.builder().itemId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("listIds must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateUserListsForItemPayload input = UpdateUserListsForItemPayloadBuilder.builder()
                .itemId("x")
                .listIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("itemId", "x"), entry("listIds", List.of("x")));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateUserListsForItemPayload input = UpdateUserListsForItemPayloadBuilder.builder()
                .clientMutationId("x")
                .itemId("x")
                .listIds(List.of("x"))
                .suggestedListIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("itemId", "x"),
                        entry("listIds", List.of("x")),
                        entry("suggestedListIds", List.of("x")));
    }
}
