package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationMigrationState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationMigrationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":\"x\""
            + "," + "\"failureReason\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"remainingRepositoriesCount\":1" + ","
            + "\"sourceOrgName\":\"x\"" + "," + "\"sourceOrgUrl\":\"x\"" + "," + "\"state\":\"FAILED\"" + ","
            + "\"targetOrgName\":\"x\"" + "," + "\"totalRepositoriesCount\":1" + "}";

    private static List<Object> readWithArguments(final OrganizationMigrationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.failureReason());
        values.add(selector.id());
        values.add(selector.remainingRepositoriesCount());
        values.add(selector.sourceOrgName());
        values.add(selector.sourceOrgUrl());
        values.add(selector.state());
        values.add(selector.targetOrgName());
        values.add(selector.totalRepositoriesCount());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationMigrationSelectorImpl(new RecordingCursor(root)));
        final OrganizationMigrationSelectorImpl selector =
                new OrganizationMigrationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        1,
                        "x",
                        "x",
                        OrganizationMigrationState.FAILED,
                        "x",
                        1);
    }
}
