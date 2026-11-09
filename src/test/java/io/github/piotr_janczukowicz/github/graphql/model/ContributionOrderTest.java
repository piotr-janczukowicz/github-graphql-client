package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ContributionOrderTest {

    @Test
    void constructor_shouldFail_whenDirectionIsNull() {
        final ContributionOrderBuilder builder = ContributionOrderBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("direction must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ContributionOrder input =
                ContributionOrderBuilder.builder().direction(OrderDirection.ASC).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("direction", "ASC"));
    }
}
