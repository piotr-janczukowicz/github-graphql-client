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
class ReferencedSubjectSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"activeLockReason\":\"OFF_TOPIC\"" + "," + "\"__typename\":\"Issue\"" + "}";

    private static List<Object> readWithArguments(final ReferencedSubjectSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(IssueSelector.class, IssueSelector::activeLockReason));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReferencedSubjectSelectorImpl(new RecordingCursor(root)));
        final ReferencedSubjectSelectorImpl selector =
                new ReferencedSubjectSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(LockReason.OFF_TOPIC);
    }
}
