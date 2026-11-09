package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PromoteRepositoryCustomPropertyPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryCustomPropertyIdIsNull() {
        final PromoteRepositoryCustomPropertyPayloadBuilder builder =
                PromoteRepositoryCustomPropertyPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("repositoryCustomPropertyId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PromoteRepositoryCustomPropertyPayload input = PromoteRepositoryCustomPropertyPayloadBuilder.builder()
                .repositoryCustomPropertyId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryCustomPropertyId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PromoteRepositoryCustomPropertyPayload input = PromoteRepositoryCustomPropertyPayloadBuilder.builder()
                .clientMutationId("x")
                .repositoryCustomPropertyId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("repositoryCustomPropertyId", "x"));
    }
}
