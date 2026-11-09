package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeletePackageVersionPayloadTest {

    @Test
    void constructor_shouldFail_whenPackageVersionIdIsNull() {
        final DeletePackageVersionPayloadBuilder builder = DeletePackageVersionPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("packageVersionId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeletePackageVersionPayload input = DeletePackageVersionPayloadBuilder.builder()
                .packageVersionId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("packageVersionId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeletePackageVersionPayload input = DeletePackageVersionPayloadBuilder.builder()
                .clientMutationId("x")
                .packageVersionId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("packageVersionId", "x"));
    }
}
