package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryCustomPropertyValuesEditableByTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepositoryCustomPropertyValuesEditableBy repositoryCustomPropertyValuesEditableBy =
                RepositoryCustomPropertyValuesEditableBy.fromWire("ORG_ACTORS");

        assertThat(repositoryCustomPropertyValuesEditableBy)
                .isEqualTo(RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepositoryCustomPropertyValuesEditableBy repositoryCustomPropertyValuesEditableBy =
                RepositoryCustomPropertyValuesEditableBy.fromWire("NOT_A_VALUE");

        assertThat(repositoryCustomPropertyValuesEditableBy)
                .isEqualTo(RepositoryCustomPropertyValuesEditableBy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepositoryCustomPropertyValuesEditableBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = RepositoryCustomPropertyValuesEditableBy.ORG_ACTORS.wireValue();

        assertThat(value).isEqualTo("ORG_ACTORS");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(RepositoryCustomPropertyValuesEditableBy.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
