package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseMembersCanCreateRepositoriesSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseMembersCanCreateRepositoriesSettingValue enterpriseMembersCanCreateRepositoriesSettingValue =
                EnterpriseMembersCanCreateRepositoriesSettingValue.fromWire("ALL");

        assertThat(enterpriseMembersCanCreateRepositoriesSettingValue)
                .isEqualTo(EnterpriseMembersCanCreateRepositoriesSettingValue.ALL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseMembersCanCreateRepositoriesSettingValue enterpriseMembersCanCreateRepositoriesSettingValue =
                EnterpriseMembersCanCreateRepositoriesSettingValue.fromWire("NOT_A_VALUE");

        assertThat(enterpriseMembersCanCreateRepositoriesSettingValue)
                .isEqualTo(EnterpriseMembersCanCreateRepositoriesSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> EnterpriseMembersCanCreateRepositoriesSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = EnterpriseMembersCanCreateRepositoriesSettingValue.ALL.wireValue();

        assertThat(value).isEqualTo("ALL");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown =
                catchThrowable(EnterpriseMembersCanCreateRepositoriesSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
