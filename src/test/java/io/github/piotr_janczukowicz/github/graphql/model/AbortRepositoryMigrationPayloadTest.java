package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AbortRepositoryMigrationPayloadTest {

    @Test
    void constructor_shouldFail_whenMigrationIdIsNull() {
        final AbortRepositoryMigrationPayloadBuilder builder = AbortRepositoryMigrationPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("migrationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AbortRepositoryMigrationPayload input = AbortRepositoryMigrationPayloadBuilder.builder()
                .migrationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("migrationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AbortRepositoryMigrationPayload input = AbortRepositoryMigrationPayloadBuilder.builder()
                .clientMutationId("x")
                .migrationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("migrationId", "x"));
    }
}
