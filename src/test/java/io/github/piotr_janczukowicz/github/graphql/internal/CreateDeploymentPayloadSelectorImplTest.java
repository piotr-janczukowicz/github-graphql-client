package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreateDeploymentPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"autoMerged\":true" + "," + "\"clientMutationId\":\"x\"" + ","
            + "\"deployment\":{\"commitOid\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final CreateDeploymentPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.autoMerged());
        values.add(selector.clientMutationId());
        values.add(selector.deployment(DeploymentSelector::commitOid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreateDeploymentPayloadSelectorImpl(new RecordingCursor(root)));
        final CreateDeploymentPayloadSelectorImpl selector =
                new CreateDeploymentPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", "x");
    }
}
