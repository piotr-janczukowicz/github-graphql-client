package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MembersCanDeleteReposClearAuditEntrySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationAuditEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"enterpriseResourcePath\":\"x\"" + ","
            + "\"__typename\":\"MembersCanDeleteReposClearAuditEntry\"" + "}";

    private static List<Object> readWithArguments(final OrganizationAuditEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.on(
                MembersCanDeleteReposClearAuditEntrySelector.class,
                MembersCanDeleteReposClearAuditEntrySelector::enterpriseResourcePath));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationAuditEntrySelectorImpl(new RecordingCursor(root)));
        final OrganizationAuditEntrySelectorImpl selector =
                new OrganizationAuditEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
