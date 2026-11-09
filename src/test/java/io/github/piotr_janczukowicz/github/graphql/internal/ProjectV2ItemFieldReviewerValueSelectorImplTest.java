package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2ItemFieldReviewerValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"reviewers\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemFieldReviewerValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.reviewers(Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemFieldReviewerValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldReviewerValueSelectorImpl selector =
                new ProjectV2ItemFieldReviewerValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(Instant.parse("2024-05-01T10:15:30Z"), new Page<>(List.of("x"), false, null));
    }
}
