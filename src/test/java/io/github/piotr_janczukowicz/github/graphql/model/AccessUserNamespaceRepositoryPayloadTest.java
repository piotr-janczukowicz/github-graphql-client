package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AccessUserNamespaceRepositoryPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final AccessUserNamespaceRepositoryPayloadBuilder builder =
                AccessUserNamespaceRepositoryPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final AccessUserNamespaceRepositoryPayloadBuilder builder =
                AccessUserNamespaceRepositoryPayloadBuilder.builder().enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AccessUserNamespaceRepositoryPayload input = AccessUserNamespaceRepositoryPayloadBuilder.builder()
                .enterpriseId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AccessUserNamespaceRepositoryPayload input = AccessUserNamespaceRepositoryPayloadBuilder.builder()
                .clientMutationId("x")
                .enterpriseId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("enterpriseId", "x"), entry("repositoryId", "x"));
    }
}
