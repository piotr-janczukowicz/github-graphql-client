package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2FieldSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProjectV2ItemFieldMilestoneValueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"field\":{\"__typename\": \"ProjectV2Field\", \"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"milestone\":{\"closed\": true}" + "}";

    private static List<Object> readWithArguments(final ProjectV2ItemFieldMilestoneValueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.field(child -> child.on(ProjectV2FieldSelector.class, ProjectV2FieldSelector::createdAt)));
        values.add(selector.milestone(MilestoneSelector::closed));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProjectV2ItemFieldMilestoneValueSelectorImpl(new RecordingCursor(root)));
        final ProjectV2ItemFieldMilestoneValueSelectorImpl selector =
                new ProjectV2ItemFieldMilestoneValueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(Instant.parse("2024-05-01T10:15:30Z"), true);
    }
}
