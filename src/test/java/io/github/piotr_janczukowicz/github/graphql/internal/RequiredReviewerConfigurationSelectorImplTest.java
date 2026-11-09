package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RequiredReviewerConfigurationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"filePatterns\":[\"x\"]" + "," + "\"minimumApprovals\":1" + "," + "\"reviewerId\":\"x\"" + "}";

    private static List<Object> readWithArguments(final RequiredReviewerConfigurationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.filePatterns());
        values.add(selector.minimumApprovals());
        values.add(selector.reviewerId());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RequiredReviewerConfigurationSelectorImpl(new RecordingCursor(root)));
        final RequiredReviewerConfigurationSelectorImpl selector =
                new RequiredReviewerConfigurationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(List.of("x"), 1, "x");
    }
}
