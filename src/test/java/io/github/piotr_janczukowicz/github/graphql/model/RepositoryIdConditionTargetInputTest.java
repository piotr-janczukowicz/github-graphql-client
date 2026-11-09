package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryIdConditionTargetInputTest {

    @Test
    void constructor_shouldFail_whenRepositoryIdsIsNull() {
        final RepositoryIdConditionTargetInputBuilder builder = RepositoryIdConditionTargetInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryIds must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RepositoryIdConditionTargetInput input = RepositoryIdConditionTargetInputBuilder.builder()
                .repositoryIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryIds", List.of("x")));
    }
}
