package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderExternalIdentitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SamlDigestAlgorithm;
import io.github.piotr_janczukowicz.github.graphql.model.SamlSignatureAlgorithm;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseIdentityProviderSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"digestMethod\":\"SHA1\"" + ","
            + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
            + "\"externalIdentities\":{\"nodes\": [{\"guid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"idpCertificate\":\"x\"" + "," + "\"issuer\":\"x\"" + ","
            + "\"recoveryCodes\":[\"x\"]" + "," + "\"signatureMethod\":\"RSA_SHA1\"" + "," + "\"ssoUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final EnterpriseIdentityProviderSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.digestMethod());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.externalIdentities(
                Paging.first(1),
                EnterpriseIdentityProviderExternalIdentitiesFilterBuilder.builder()
                        .login("x")
                        .membersOnly(true)
                        .userName("x")
                        .build(),
                ExternalIdentitySelector::guid));
        values.add(selector.id());
        values.add(selector.idpCertificate());
        values.add(selector.issuer());
        values.add(selector.recoveryCodes());
        values.add(selector.signatureMethod());
        values.add(selector.ssoUrl());
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseIdentityProviderSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.externalIdentities(Paging.first(1), ExternalIdentitySelector::guid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseIdentityProviderSelectorImpl(new RecordingCursor(root)));
        final EnterpriseIdentityProviderSelectorImpl selector =
                new EnterpriseIdentityProviderSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        SamlDigestAlgorithm.SHA1,
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        List.of("x"),
                        SamlSignatureAlgorithm.RSA_SHA1,
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseIdentityProviderSelectorImpl(new RecordingCursor(root)));
        final EnterpriseIdentityProviderSelectorImpl selector =
                new EnterpriseIdentityProviderSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
