package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.MigrationSourceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MigrationState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryMigrationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"continueOnError\":true" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":\"x\"" + "," + "\"failureReason\":\"x\""
            + "," + "\"id\":\"x\"" + "," + "\"migrationLogUrl\":\"x\"" + "," + "\"migrationSource\":{\"id\": \"x\"}"
            + "," + "\"repositoryName\":\"x\"" + "," + "\"sourceUrl\":\"x\"" + "," + "\"state\":\"FAILED\"" + ","
            + "\"warningsCount\":1" + "}";

    private static List<Object> readWithArguments(final RepositoryMigrationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.continueOnError());
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.failureReason());
        values.add(selector.id());
        values.add(selector.migrationLogUrl());
        values.add(selector.migrationSource(MigrationSourceSelector::id));
        values.add(selector.repositoryName());
        values.add(selector.sourceUrl());
        values.add(selector.state());
        values.add(selector.warningsCount());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryMigrationSelectorImpl(new RecordingCursor(root)));
        final RepositoryMigrationSelectorImpl selector =
                new RepositoryMigrationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        MigrationState.FAILED,
                        1);
    }
}
