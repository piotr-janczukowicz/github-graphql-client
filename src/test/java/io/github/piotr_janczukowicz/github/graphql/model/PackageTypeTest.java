package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PackageTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PackageType packageType = PackageType.fromWire("DEBIAN");

        assertThat(packageType).isEqualTo(PackageType.DEBIAN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PackageType packageType = PackageType.fromWire("NOT_A_VALUE");

        assertThat(packageType).isEqualTo(PackageType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PackageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
