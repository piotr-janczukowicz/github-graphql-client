package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateMigrationSourcePayloadTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateMigrationSourcePayloadBuilder builder =
                CreateMigrationSourcePayloadBuilder.builder().ownerId("x").type(MigrationSourceType.AZURE_DEVOPS);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CreateMigrationSourcePayloadBuilder builder =
                CreateMigrationSourcePayloadBuilder.builder().name("x").type(MigrationSourceType.AZURE_DEVOPS);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTypeIsNull() {
        final CreateMigrationSourcePayloadBuilder builder =
                CreateMigrationSourcePayloadBuilder.builder().name("x").ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("type must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateMigrationSourcePayload input = CreateMigrationSourcePayloadBuilder.builder()
                .name("x")
                .ownerId("x")
                .type(MigrationSourceType.AZURE_DEVOPS)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("name", "x"), entry("ownerId", "x"), entry("type", "AZURE_DEVOPS"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateMigrationSourcePayload input = CreateMigrationSourcePayloadBuilder.builder()
                .accessToken("x")
                .clientMutationId("x")
                .githubPat("x")
                .name("x")
                .ownerId("x")
                .type(MigrationSourceType.AZURE_DEVOPS)
                .url("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("accessToken", "x"),
                        entry("clientMutationId", "x"),
                        entry("githubPat", "x"),
                        entry("name", "x"),
                        entry("ownerId", "x"),
                        entry("type", "AZURE_DEVOPS"),
                        entry("url", "x"));
    }
}
