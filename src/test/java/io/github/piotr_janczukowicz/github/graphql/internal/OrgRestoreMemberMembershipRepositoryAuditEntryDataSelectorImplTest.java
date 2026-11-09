package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"repositoryName\":\"x\"" + ","
                    + "\"repositoryResourcePath\":\"x\"" + "," + "\"repositoryUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(
            final OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.repositoryName());
        values.add(selector.repositoryResourcePath());
        values.add(selector.repositoryUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(
                new OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl(new RecordingCursor(root)));
        final OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl selector =
                new OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", "x", "x");
    }
}
