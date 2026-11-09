package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RenamedTitleSubjectSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"__typename\":\"Issue\"" + "}";

    private static List<Object> readWithArguments(final RenamedTitleSubjectSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(IssueSelector.class, IssueSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RenamedTitleSubjectSelectorImpl(new RecordingCursor(root)));
        final RenamedTitleSubjectSelectorImpl selector =
                new RenamedTitleSubjectSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(LockReason.OFF_TOPIC);
    }
}
