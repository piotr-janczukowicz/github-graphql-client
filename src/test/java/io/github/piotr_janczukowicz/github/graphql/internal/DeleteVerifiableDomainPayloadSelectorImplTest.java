package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeleteVerifiableDomainPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"owner\":{\"__typename\": \"Enterprise\", \"avatarUrl\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final DeleteVerifiableDomainPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.owner(child -> child.on(EnterpriseSelector.class, EnterpriseSelector::avatarUrl)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeleteVerifiableDomainPayloadSelectorImpl(new RecordingCursor(root)));
        final DeleteVerifiableDomainPayloadSelectorImpl selector =
                new DeleteVerifiableDomainPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x");
    }
}
