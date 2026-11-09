package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeploymentReviewSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"comment\":\"x\"" + "," + "\"databaseId\":1" + ","
            + "\"environments\":{\"nodes\": [{\"databaseId\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"state\":\"APPROVED\"" + "," + "\"user\":{\"anyPinnableItems\": true}"
            + "}";

    private static List<Object> readWithArguments(final DeploymentReviewSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.comment());
        values.add(selector.databaseId());
        values.add(selector.environments(Paging.first(1), EnvironmentSelector::databaseId));
        values.add(selector.id());
        values.add(selector.state());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeploymentReviewSelectorImpl(new RecordingCursor(root)));
        final DeploymentReviewSelectorImpl selector =
                new DeploymentReviewSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", 1, new Page<>(List.of(1), false, null), "x", DeploymentReviewState.APPROVED, true);
    }
}
