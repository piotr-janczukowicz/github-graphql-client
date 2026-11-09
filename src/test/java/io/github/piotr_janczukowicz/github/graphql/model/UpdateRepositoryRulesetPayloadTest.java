package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateRepositoryRulesetPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryRulesetIdIsNull() {
        final UpdateRepositoryRulesetPayloadBuilder builder = UpdateRepositoryRulesetPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryRulesetId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateRepositoryRulesetPayload input = UpdateRepositoryRulesetPayloadBuilder.builder()
                .repositoryRulesetId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryRulesetId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateRepositoryRulesetPayload input = UpdateRepositoryRulesetPayloadBuilder.builder()
                .bypassActors(List.of(RepositoryRulesetBypassActorInputBuilder.builder()
                        .bypassMode(RepositoryRulesetBypassActorBypassMode.ALWAYS)
                        .build()))
                .clientMutationId("x")
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .enforcement(RuleEnforcement.ACTIVE)
                .name("x")
                .repositoryRulesetId("x")
                .rules(List.of(RepositoryRuleInputBuilder.builder()
                        .type(RepositoryRuleType.AUTHORIZATION)
                        .build()))
                .target(RepositoryRulesetTarget.BRANCH)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("bypassActors", List.of(Map.ofEntries(entry("bypassMode", "ALWAYS")))),
                        entry("clientMutationId", "x"),
                        entry("conditions", Map.ofEntries()),
                        entry("enforcement", "ACTIVE"),
                        entry("name", "x"),
                        entry("repositoryRulesetId", "x"),
                        entry("rules", List.of(Map.ofEntries(entry("type", "AUTHORIZATION")))),
                        entry("target", "BRANCH"));
    }
}
