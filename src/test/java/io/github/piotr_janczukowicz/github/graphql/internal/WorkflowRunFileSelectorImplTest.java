package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.WorkflowRunSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class WorkflowRunFileSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"path\":\"x\"" + ","
            + "\"repositoryFileUrl\":\"x\"" + "," + "\"repositoryName\":\"x\"" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"run\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"url\":\"x\"" + ","
            + "\"viewerCanPushRepository\":true" + "," + "\"viewerCanReadRepository\":true" + "}";

    private static List<Object> readWithArguments(final WorkflowRunFileSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.path());
        values.add(selector.repositoryFileUrl());
        values.add(selector.repositoryName());
        values.add(selector.resourcePath());
        values.add(selector.run(WorkflowRunSelector::createdAt));
        values.add(selector.url());
        values.add(selector.viewerCanPushRepository());
        values.add(selector.viewerCanReadRepository());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new WorkflowRunFileSelectorImpl(new RecordingCursor(root)));
        final WorkflowRunFileSelectorImpl selector =
                new WorkflowRunFileSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", "x", "x", "x", "x", Instant.parse("2024-05-01T10:15:30Z"), "x", true, true);
    }
}
