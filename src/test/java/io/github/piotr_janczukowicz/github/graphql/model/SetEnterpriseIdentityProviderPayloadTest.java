package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SetEnterpriseIdentityProviderPayloadTest {

    @Test
    void constructor_shouldFail_whenDigestMethodIsNull() {
        final SetEnterpriseIdentityProviderPayloadBuilder builder =
                SetEnterpriseIdentityProviderPayloadBuilder.builder()
                        .enterpriseId("x")
                        .idpCertificate("x")
                        .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1)
                        .ssoUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("digestMethod must not be null");
    }

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final SetEnterpriseIdentityProviderPayloadBuilder builder =
                SetEnterpriseIdentityProviderPayloadBuilder.builder()
                        .digestMethod(SamlDigestAlgorithm.SHA1)
                        .idpCertificate("x")
                        .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1)
                        .ssoUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenIdpCertificateIsNull() {
        final SetEnterpriseIdentityProviderPayloadBuilder builder =
                SetEnterpriseIdentityProviderPayloadBuilder.builder()
                        .digestMethod(SamlDigestAlgorithm.SHA1)
                        .enterpriseId("x")
                        .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1)
                        .ssoUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("idpCertificate must not be null");
    }

    @Test
    void constructor_shouldFail_whenSignatureMethodIsNull() {
        final SetEnterpriseIdentityProviderPayloadBuilder builder =
                SetEnterpriseIdentityProviderPayloadBuilder.builder()
                        .digestMethod(SamlDigestAlgorithm.SHA1)
                        .enterpriseId("x")
                        .idpCertificate("x")
                        .ssoUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("signatureMethod must not be null");
    }

    @Test
    void constructor_shouldFail_whenSsoUrlIsNull() {
        final SetEnterpriseIdentityProviderPayloadBuilder builder =
                SetEnterpriseIdentityProviderPayloadBuilder.builder()
                        .digestMethod(SamlDigestAlgorithm.SHA1)
                        .enterpriseId("x")
                        .idpCertificate("x")
                        .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ssoUrl must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SetEnterpriseIdentityProviderPayload input = SetEnterpriseIdentityProviderPayloadBuilder.builder()
                .digestMethod(SamlDigestAlgorithm.SHA1)
                .enterpriseId("x")
                .idpCertificate("x")
                .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1)
                .ssoUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("digestMethod", "SHA1"),
                        entry("enterpriseId", "x"),
                        entry("idpCertificate", "x"),
                        entry("signatureMethod", "RSA_SHA1"),
                        entry("ssoUrl", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SetEnterpriseIdentityProviderPayload input = SetEnterpriseIdentityProviderPayloadBuilder.builder()
                .clientMutationId("x")
                .digestMethod(SamlDigestAlgorithm.SHA1)
                .enterpriseId("x")
                .idpCertificate("x")
                .issuer("x")
                .signatureMethod(SamlSignatureAlgorithm.RSA_SHA1)
                .ssoUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("digestMethod", "SHA1"),
                        entry("enterpriseId", "x"),
                        entry("idpCertificate", "x"),
                        entry("issuer", "x"),
                        entry("signatureMethod", "RSA_SHA1"),
                        entry("ssoUrl", "x"));
    }
}
