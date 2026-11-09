package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeQueueParametersInputTest {

    @Test
    void constructor_shouldFail_whenCheckResponseTimeoutMinutesIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("checkResponseTimeoutMinutes must not be null");
    }

    @Test
    void constructor_shouldFail_whenGroupingStrategyIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("groupingStrategy must not be null");
    }

    @Test
    void constructor_shouldFail_whenMaxEntriesToBuildIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("maxEntriesToBuild must not be null");
    }

    @Test
    void constructor_shouldFail_whenMaxEntriesToMergeIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("maxEntriesToMerge must not be null");
    }

    @Test
    void constructor_shouldFail_whenMergeMethodIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("mergeMethod must not be null");
    }

    @Test
    void constructor_shouldFail_whenMinEntriesToMergeIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMergeWaitMinutes(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("minEntriesToMerge must not be null");
    }

    @Test
    void constructor_shouldFail_whenMinEntriesToMergeWaitMinutesIsNull() {
        final MergeQueueParametersInputBuilder builder = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("minEntriesToMergeWaitMinutes must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MergeQueueParametersInput input = MergeQueueParametersInputBuilder.builder()
                .checkResponseTimeoutMinutes(1)
                .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                .maxEntriesToBuild(1)
                .maxEntriesToMerge(1)
                .mergeMethod(MergeQueueMergeMethod.MERGE)
                .minEntriesToMerge(1)
                .minEntriesToMergeWaitMinutes(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("checkResponseTimeoutMinutes", 1),
                        entry("groupingStrategy", "ALLGREEN"),
                        entry("maxEntriesToBuild", 1),
                        entry("maxEntriesToMerge", 1),
                        entry("mergeMethod", "MERGE"),
                        entry("minEntriesToMerge", 1),
                        entry("minEntriesToMergeWaitMinutes", 1));
    }
}
