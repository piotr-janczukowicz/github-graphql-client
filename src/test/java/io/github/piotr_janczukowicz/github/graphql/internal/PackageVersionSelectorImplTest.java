package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PackageFileOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionFilesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionStatisticsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PackageVersionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"files\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"package\":{\"id\": \"x\"}" + "," + "\"platform\":\"x\"" + ","
            + "\"preRelease\":true" + "," + "\"readme\":\"x\"" + ","
            + "\"release\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
            + "\"statistics\":{\"downloadsTotalCount\": 1}" + "," + "\"summary\":\"x\"" + "," + "\"version\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final PackageVersionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.files(
                Paging.first(1),
                PackageVersionFilesFilterBuilder.builder()
                        .orderBy(PackageFileOrderBuilder.builder().build())
                        .build(),
                PackageFileSelector::id));
        values.add(selector.id());
        values.add(selector.packageValue(PackageSelector::id));
        values.add(selector.platform());
        values.add(selector.preRelease());
        values.add(selector.readme());
        values.add(selector.release(ReleaseSelector::createdAt));
        values.add(selector.statistics(PackageVersionStatisticsSelector::downloadsTotalCount));
        values.add(selector.summary());
        values.add(selector.version());
        return values;
    }

    private static List<Object> readWithoutArguments(final PackageVersionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.files(Paging.first(1), PackageFileSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PackageVersionSelectorImpl(new RecordingCursor(root)));
        final PackageVersionSelectorImpl selector =
                new PackageVersionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        true,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        "x",
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new PackageVersionSelectorImpl(new RecordingCursor(root)));
        final PackageVersionSelectorImpl selector =
                new PackageVersionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
