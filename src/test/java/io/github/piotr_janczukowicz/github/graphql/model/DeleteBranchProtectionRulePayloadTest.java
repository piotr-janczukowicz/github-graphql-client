package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteBranchProtectionRulePayloadTest {

    @Test
    void constructor_shouldFail_whenBranchProtectionRuleIdIsNull() {
        final DeleteBranchProtectionRulePayloadBuilder builder = DeleteBranchProtectionRulePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("branchProtectionRuleId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteBranchProtectionRulePayload input = DeleteBranchProtectionRulePayloadBuilder.builder()
                .branchProtectionRuleId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("branchProtectionRuleId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteBranchProtectionRulePayload input = DeleteBranchProtectionRulePayloadBuilder.builder()
                .branchProtectionRuleId("x")
                .clientMutationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("branchProtectionRuleId", "x"), entry("clientMutationId", "x"));
    }
}
