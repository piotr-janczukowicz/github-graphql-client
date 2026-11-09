package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MigrationSourceTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MigrationSourceType migrationSourceType = MigrationSourceType.fromWire("AZURE_DEVOPS");

        assertThat(migrationSourceType).isEqualTo(MigrationSourceType.AZURE_DEVOPS);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MigrationSourceType migrationSourceType = MigrationSourceType.fromWire("NOT_A_VALUE");

        assertThat(migrationSourceType).isEqualTo(MigrationSourceType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MigrationSourceType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = MigrationSourceType.AZURE_DEVOPS.wireValue();

        assertThat(value).isEqualTo("AZURE_DEVOPS");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(MigrationSourceType.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
