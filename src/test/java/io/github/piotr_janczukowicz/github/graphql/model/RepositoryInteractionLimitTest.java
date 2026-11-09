package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryInteractionLimitTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepositoryInteractionLimit repositoryInteractionLimit =
                RepositoryInteractionLimit.fromWire("COLLABORATORS_ONLY");

        assertThat(repositoryInteractionLimit).isEqualTo(RepositoryInteractionLimit.COLLABORATORS_ONLY);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepositoryInteractionLimit repositoryInteractionLimit =
                RepositoryInteractionLimit.fromWire("NOT_A_VALUE");

        assertThat(repositoryInteractionLimit).isEqualTo(RepositoryInteractionLimit.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepositoryInteractionLimit.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = RepositoryInteractionLimit.COLLABORATORS_ONLY.wireValue();

        assertThat(value).isEqualTo("COLLABORATORS_ONLY");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(RepositoryInteractionLimit.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
