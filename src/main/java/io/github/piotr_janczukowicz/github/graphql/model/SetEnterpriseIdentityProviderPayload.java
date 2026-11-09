package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code SetEnterpriseIdentityProviderInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record SetEnterpriseIdentityProviderPayload(
        @Nullable String clientMutationId,
        SamlDigestAlgorithm digestMethod,
        String enterpriseId,
        String idpCertificate,
        @Nullable String issuer,
        SamlSignatureAlgorithm signatureMethod,
        String ssoUrl) {

    public SetEnterpriseIdentityProviderPayload {
        requireNonNull(digestMethod, "digestMethod");
        requireNonNull(enterpriseId, "enterpriseId");
        requireNonNull(idpCertificate, "idpCertificate");
        requireNonNull(signatureMethod, "signatureMethod");
        requireNonNull(ssoUrl, "ssoUrl");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("digestMethod", this.digestMethod.wireValue());
        variable.put("enterpriseId", this.enterpriseId);
        variable.put("idpCertificate", this.idpCertificate);
        if (this.issuer != null) {
            variable.put("issuer", this.issuer);
        }
        variable.put("signatureMethod", this.signatureMethod.wireValue());
        variable.put("ssoUrl", this.ssoUrl);
        return Collections.unmodifiableMap(variable);
    }
}
