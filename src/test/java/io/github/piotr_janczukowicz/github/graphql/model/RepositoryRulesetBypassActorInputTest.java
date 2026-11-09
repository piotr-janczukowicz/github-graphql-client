package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryRulesetBypassActorInputTest {

    @Test
    void constructor_shouldFail_whenBypassModeIsNull() {
        final RepositoryRulesetBypassActorInputBuilder builder = RepositoryRulesetBypassActorInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("bypassMode must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RepositoryRulesetBypassActorInput input = RepositoryRulesetBypassActorInputBuilder.builder()
                .bypassMode(RepositoryRulesetBypassActorBypassMode.ALWAYS)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("bypassMode", "ALWAYS"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RepositoryRulesetBypassActorInput input = RepositoryRulesetBypassActorInputBuilder.builder()
                .actorId("x")
                .bypassMode(RepositoryRulesetBypassActorBypassMode.ALWAYS)
                .deployKey(true)
                .enterpriseOwner(true)
                .enterpriseRole(true)
                .enterpriseRoleDatabaseId(BigInteger.ONE)
                .organizationAdmin(true)
                .repositoryRoleDatabaseId(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("actorId", "x"),
                        entry("bypassMode", "ALWAYS"),
                        entry("deployKey", true),
                        entry("enterpriseOwner", true),
                        entry("enterpriseRole", true),
                        entry("enterpriseRoleDatabaseId", "1"),
                        entry("organizationAdmin", true),
                        entry("repositoryRoleDatabaseId", 1));
    }
}
