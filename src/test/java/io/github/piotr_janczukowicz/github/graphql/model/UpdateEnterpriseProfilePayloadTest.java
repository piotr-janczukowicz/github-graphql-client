package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseProfilePayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseProfilePayloadBuilder builder = UpdateEnterpriseProfilePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseProfilePayload input = UpdateEnterpriseProfilePayloadBuilder.builder()
                .enterpriseId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseProfilePayload input = UpdateEnterpriseProfilePayloadBuilder.builder()
                .clientMutationId("x")
                .description("x")
                .enterpriseId("x")
                .location("x")
                .name("x")
                .securityContactEmail("x")
                .websiteUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("enterpriseId", "x"),
                        entry("location", "x"),
                        entry("name", "x"),
                        entry("securityContactEmail", "x"),
                        entry("websiteUrl", "x"));
    }
}
