package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RevokeMigratorRolePayloadTest {

    @Test
    void constructor_shouldFail_whenActorIsNull() {
        final RevokeMigratorRolePayloadBuilder builder = RevokeMigratorRolePayloadBuilder.builder()
                .actorType(ActorType.TEAM)
                .organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("actor must not be null");
    }

    @Test
    void constructor_shouldFail_whenActorTypeIsNull() {
        final RevokeMigratorRolePayloadBuilder builder =
                RevokeMigratorRolePayloadBuilder.builder().actor("x").organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("actorType must not be null");
    }

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final RevokeMigratorRolePayloadBuilder builder =
                RevokeMigratorRolePayloadBuilder.builder().actor("x").actorType(ActorType.TEAM);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RevokeMigratorRolePayload input = RevokeMigratorRolePayloadBuilder.builder()
                .actor("x")
                .actorType(ActorType.TEAM)
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("actor", "x"), entry("actorType", "TEAM"), entry("organizationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RevokeMigratorRolePayload input = RevokeMigratorRolePayloadBuilder.builder()
                .actor("x")
                .actorType(ActorType.TEAM)
                .clientMutationId("x")
                .organizationId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("actor", "x"),
                        entry("actorType", "TEAM"),
                        entry("clientMutationId", "x"),
                        entry("organizationId", "x"));
    }
}
