package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteRepositoryRulesetPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryRulesetIdIsNull() {
        final DeleteRepositoryRulesetPayloadBuilder builder = DeleteRepositoryRulesetPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryRulesetId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteRepositoryRulesetPayload input = DeleteRepositoryRulesetPayloadBuilder.builder()
                .repositoryRulesetId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryRulesetId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteRepositoryRulesetPayload input = DeleteRepositoryRulesetPayloadBuilder.builder()
                .clientMutationId("x")
                .repositoryRulesetId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("repositoryRulesetId", "x"));
    }
}
