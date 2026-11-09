package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RefUpdateRuleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowsDeletions\":true" + "," + "\"allowsForcePushes\":true" + ","
            + "\"blocksCreations\":true" + "," + "\"pattern\":\"x\"" + "," + "\"requiredApprovingReviewCount\":1" + ","
            + "\"requiredStatusCheckContexts\":[\"x\"]" + "," + "\"requiresCodeOwnerReviews\":true" + ","
            + "\"requiresConversationResolution\":true" + "," + "\"requiresLinearHistory\":true" + ","
            + "\"requiresSignatures\":true" + "," + "\"viewerAllowedToDismissReviews\":true" + ","
            + "\"viewerCanPush\":true" + "}";

    private static List<Object> readWithArguments(final RefUpdateRuleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowsDeletions());
        values.add(selector.allowsForcePushes());
        values.add(selector.blocksCreations());
        values.add(selector.pattern());
        values.add(selector.requiredApprovingReviewCount());
        values.add(selector.requiredStatusCheckContexts());
        values.add(selector.requiresCodeOwnerReviews());
        values.add(selector.requiresConversationResolution());
        values.add(selector.requiresLinearHistory());
        values.add(selector.requiresSignatures());
        values.add(selector.viewerAllowedToDismissReviews());
        values.add(selector.viewerCanPush());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RefUpdateRuleSelectorImpl(new RecordingCursor(root)));
        final RefUpdateRuleSelectorImpl selector =
                new RefUpdateRuleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, true, true, "x", 1, List.of("x"), true, true, true, true, true, true);
    }
}
