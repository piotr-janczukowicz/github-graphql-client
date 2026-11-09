package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddVerifiableDomainPayloadTest {

    @Test
    void constructor_shouldFail_whenDomainIsNull() {
        final AddVerifiableDomainPayloadBuilder builder =
                AddVerifiableDomainPayloadBuilder.builder().ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("domain must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final AddVerifiableDomainPayloadBuilder builder =
                AddVerifiableDomainPayloadBuilder.builder().domain("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddVerifiableDomainPayload input = AddVerifiableDomainPayloadBuilder.builder()
                .domain("x")
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("domain", "x"), entry("ownerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddVerifiableDomainPayload input = AddVerifiableDomainPayloadBuilder.builder()
                .clientMutationId("x")
                .domain("x")
                .ownerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("domain", "x"), entry("ownerId", "x"));
    }
}
