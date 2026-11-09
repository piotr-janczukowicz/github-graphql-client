package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryInteractionLimitOriginTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepositoryInteractionLimitOrigin repositoryInteractionLimitOrigin =
                RepositoryInteractionLimitOrigin.fromWire("ORGANIZATION");

        assertThat(repositoryInteractionLimitOrigin).isEqualTo(RepositoryInteractionLimitOrigin.ORGANIZATION);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepositoryInteractionLimitOrigin repositoryInteractionLimitOrigin =
                RepositoryInteractionLimitOrigin.fromWire("NOT_A_VALUE");

        assertThat(repositoryInteractionLimitOrigin).isEqualTo(RepositoryInteractionLimitOrigin.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepositoryInteractionLimitOrigin.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
