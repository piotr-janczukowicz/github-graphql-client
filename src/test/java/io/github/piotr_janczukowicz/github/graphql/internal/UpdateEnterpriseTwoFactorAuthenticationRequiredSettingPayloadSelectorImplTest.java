package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"enterprise\":{\"avatarUrl\": \"x\"}" + "," + "\"message\":\"x\"" + "}";

    private static List<Object> readWithArguments(
            final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.message());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelectorImpl(
                new RecordingCursor(root)));
        final UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelectorImpl selector =
                new UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x");
    }
}
