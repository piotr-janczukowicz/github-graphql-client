package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationOrderTest {

    @Test
    void constructor_shouldFail_whenDirectionIsNull() {
        final OrganizationOrderBuilder builder =
                OrganizationOrderBuilder.builder().field(OrganizationOrderField.CREATED_AT);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("direction must not be null");
    }

    @Test
    void constructor_shouldFail_whenFieldIsNull() {
        final OrganizationOrderBuilder builder =
                OrganizationOrderBuilder.builder().direction(OrderDirection.ASC);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("field must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final OrganizationOrder input = OrganizationOrderBuilder.builder()
                .direction(OrderDirection.ASC)
                .field(OrganizationOrderField.CREATED_AT)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("direction", "ASC"), entry("field", "CREATED_AT"));
    }
}
