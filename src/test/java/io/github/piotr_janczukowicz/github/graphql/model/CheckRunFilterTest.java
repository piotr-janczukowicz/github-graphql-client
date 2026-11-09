package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckRunFilterTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckRunFilter input = CheckRunFilterBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckRunFilter input = CheckRunFilterBuilder.builder()
                .appId(1)
                .checkName("x")
                .checkType(CheckRunType.ALL)
                .conclusions(List.of(CheckConclusionState.ACTION_REQUIRED))
                .status(CheckStatusState.COMPLETED)
                .statuses(List.of(CheckStatusState.COMPLETED))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("appId", 1),
                        entry("checkName", "x"),
                        entry("checkType", "ALL"),
                        entry("conclusions", List.of("ACTION_REQUIRED")),
                        entry("status", "COMPLETED"),
                        entry("statuses", List.of("COMPLETED")));
    }
}
