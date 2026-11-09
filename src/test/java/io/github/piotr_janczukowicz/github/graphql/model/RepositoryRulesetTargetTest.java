package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryRulesetTargetTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepositoryRulesetTarget repositoryRulesetTarget = RepositoryRulesetTarget.fromWire("BRANCH");

        assertThat(repositoryRulesetTarget).isEqualTo(RepositoryRulesetTarget.BRANCH);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepositoryRulesetTarget repositoryRulesetTarget = RepositoryRulesetTarget.fromWire("NOT_A_VALUE");

        assertThat(repositoryRulesetTarget).isEqualTo(RepositoryRulesetTarget.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepositoryRulesetTarget.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = RepositoryRulesetTarget.BRANCH.wireValue();

        assertThat(value).isEqualTo("BRANCH");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(RepositoryRulesetTarget.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
