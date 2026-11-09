package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.DismissalRestrictionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestAllowedMergeMethods;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredReviewerConfigurationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestParametersSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allowedMergeMethods\":[\"MERGE\"]" + ","
            + "\"dismissStaleReviewsOnPush\":true" + "," + "\"dismissalRestriction\":{\"allowedActors\": [\"x\"]}" + ","
            + "\"requireCodeOwnerReview\":true" + "," + "\"requireExtraApprovalForUnattributedChanges\":true" + ","
            + "\"requireLastPushApproval\":true" + "," + "\"requiredApprovingReviewCount\":1" + ","
            + "\"requiredReviewThreadResolution\":true" + "," + "\"requiredReviewers\":[{\"filePatterns\": [\"x\"]}]"
            + "}";

    private static List<Object> readWithArguments(final PullRequestParametersSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allowedMergeMethods());
        values.add(selector.dismissStaleReviewsOnPush());
        values.add(selector.dismissalRestriction(DismissalRestrictionSelector::allowedActors));
        values.add(selector.requireCodeOwnerReview());
        values.add(selector.requireExtraApprovalForUnattributedChanges());
        values.add(selector.requireLastPushApproval());
        values.add(selector.requiredApprovingReviewCount());
        values.add(selector.requiredReviewThreadResolution());
        values.add(selector.requiredReviewers(RequiredReviewerConfigurationSelector::filePatterns));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestParametersSelectorImpl(new RecordingCursor(root)));
        final PullRequestParametersSelectorImpl selector =
                new PullRequestParametersSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of(PullRequestAllowedMergeMethods.MERGE),
                        true,
                        List.of("x"),
                        true,
                        true,
                        true,
                        1,
                        true,
                        List.of(List.of("x")));
    }
}
