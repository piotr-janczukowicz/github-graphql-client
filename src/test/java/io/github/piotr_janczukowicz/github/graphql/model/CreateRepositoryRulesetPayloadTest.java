package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateRepositoryRulesetPayloadTest {

    @Test
    void constructor_shouldFail_whenConditionsIsNull() {
        final CreateRepositoryRulesetPayloadBuilder builder = CreateRepositoryRulesetPayloadBuilder.builder()
                .enforcement(RuleEnforcement.ACTIVE)
                .name("x")
                .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("conditions must not be null");
    }

    @Test
    void constructor_shouldFail_whenEnforcementIsNull() {
        final CreateRepositoryRulesetPayloadBuilder builder = CreateRepositoryRulesetPayloadBuilder.builder()
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .name("x")
                .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enforcement must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateRepositoryRulesetPayloadBuilder builder = CreateRepositoryRulesetPayloadBuilder.builder()
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .enforcement(RuleEnforcement.ACTIVE)
                .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceIdIsNull() {
        final CreateRepositoryRulesetPayloadBuilder builder = CreateRepositoryRulesetPayloadBuilder.builder()
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .enforcement(RuleEnforcement.ACTIVE)
                .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateRepositoryRulesetPayload input = CreateRepositoryRulesetPayloadBuilder.builder()
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .enforcement(RuleEnforcement.ACTIVE)
                .name("x")
                .sourceId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("conditions", Map.ofEntries()),
                        entry("enforcement", "ACTIVE"),
                        entry("name", "x"),
                        entry("sourceId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateRepositoryRulesetPayload input = CreateRepositoryRulesetPayloadBuilder.builder()
                .bypassActors(List.of(RepositoryRulesetBypassActorInputBuilder.builder()
                        .bypassMode(RepositoryRulesetBypassActorBypassMode.ALWAYS)
                        .build()))
                .clientMutationId("x")
                .conditions(RepositoryRuleConditionsInputBuilder.builder().build())
                .enforcement(RuleEnforcement.ACTIVE)
                .name("x")
                .rules(List.of(RepositoryRuleInputBuilder.builder()
                        .type(RepositoryRuleType.AUTHORIZATION)
                        .build()))
                .sourceId("x")
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
                        entry("rules", List.of(Map.ofEntries(entry("type", "AUTHORIZATION")))),
                        entry("sourceId", "x"),
                        entry("target", "BRANCH"));
    }
}
