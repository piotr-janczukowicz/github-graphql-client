package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DismissalRestrictionInputTest {

    @Test
    void constructor_shouldFail_whenEnabledIsNull() {
        final DismissalRestrictionInputBuilder builder = DismissalRestrictionInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enabled must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DismissalRestrictionInput input =
                DismissalRestrictionInputBuilder.builder().enabled(true).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enabled", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DismissalRestrictionInput input = DismissalRestrictionInputBuilder.builder()
                .allowedActors(List.of("x"))
                .enabled(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("allowedActors", List.of("x")), entry("enabled", true));
    }
}
