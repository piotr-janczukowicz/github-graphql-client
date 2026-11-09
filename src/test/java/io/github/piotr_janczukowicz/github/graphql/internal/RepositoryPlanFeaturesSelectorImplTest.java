package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryPlanFeaturesSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"codeowners\":true" + "," + "\"draftPullRequests\":true" + "," + "\"maximumAssignees\":1" + ","
                    + "\"maximumManualReviewRequests\":1" + "," + "\"teamReviewRequests\":true" + "}";

    private static List<Object> readWithArguments(final RepositoryPlanFeaturesSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.codeowners());
        values.add(selector.draftPullRequests());
        values.add(selector.maximumAssignees());
        values.add(selector.maximumManualReviewRequests());
        values.add(selector.teamReviewRequests());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryPlanFeaturesSelectorImpl(new RecordingCursor(root)));
        final RepositoryPlanFeaturesSelectorImpl selector =
                new RepositoryPlanFeaturesSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, true, 1, 1, true);
    }
}
