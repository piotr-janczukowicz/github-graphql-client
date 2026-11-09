package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"organization\":{\"anyPinnableItems\": true}" + "," + "\"organizationName\":\"x\"" + ","
                    + "\"organizationResourcePath\":\"x\"" + "," + "\"organizationUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(
            final OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.organization(OrganizationSelector::anyPinnableItems));
        values.add(selector.organizationName());
        values.add(selector.organizationResourcePath());
        values.add(selector.organizationUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(
                new OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl(new RecordingCursor(root)));
        final OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl selector =
                new OrgRestoreMemberMembershipOrganizationAuditEntryDataSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", "x", "x");
    }
}
