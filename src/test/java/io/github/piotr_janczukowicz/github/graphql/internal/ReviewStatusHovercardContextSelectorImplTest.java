package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewDecision;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReviewStatusHovercardContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"message\":\"x\"" + "," + "\"octicon\":\"x\"" + "," + "\"reviewDecision\":\"APPROVED\"" + "}";

    private static List<Object> readWithArguments(final ReviewStatusHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.message());
        values.add(selector.octicon());
        values.add(selector.reviewDecision());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReviewStatusHovercardContextSelectorImpl(new RecordingCursor(root)));
        final ReviewStatusHovercardContextSelectorImpl selector =
                new ReviewStatusHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", PullRequestReviewDecision.APPROVED);
    }
}
