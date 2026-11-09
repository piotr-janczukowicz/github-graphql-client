package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderExternalIdentitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderType;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OIDCProviderSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
            + "\"externalIdentities\":{\"nodes\": [{\"guid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"providerType\":\"AAD\"" + "," + "\"tenantId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final OIDCProviderSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.externalIdentities(
                Paging.first(1),
                OIDCProviderExternalIdentitiesFilterBuilder.builder()
                        .login("x")
                        .membersOnly(true)
                        .userName("x")
                        .build(),
                ExternalIdentitySelector::guid));
        values.add(selector.id());
        values.add(selector.providerType());
        values.add(selector.tenantId());
        return values;
    }

    private static List<Object> readWithoutArguments(final OIDCProviderSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.externalIdentities(Paging.first(1), ExternalIdentitySelector::guid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OIDCProviderSelectorImpl(new RecordingCursor(root)));
        final OIDCProviderSelectorImpl selector =
                new OIDCProviderSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", new Page<>(List.of("x"), false, null), "x", OIDCProviderType.AAD, "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new OIDCProviderSelectorImpl(new RecordingCursor(root)));
        final OIDCProviderSelectorImpl selector =
                new OIDCProviderSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
