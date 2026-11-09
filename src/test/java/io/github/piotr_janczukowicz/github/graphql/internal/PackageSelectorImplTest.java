package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PackageStatisticsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageType;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PackageSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"id\":\"x\"" + "," + "\"latestVersion\":{\"id\": \"x\"}" + "," + "\"name\":\"x\"" + ","
                    + "\"packageType\":\"DEBIAN\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
                    + "\"statistics\":{\"downloadsTotalCount\": 1}" + "," + "\"version\":{\"id\": \"x\"}" + ","
                    + "\"versions\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "}";

    private static List<Object> readWithArguments(final PackageSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.latestVersion(PackageVersionSelector::id));
        values.add(selector.name());
        values.add(selector.packageType());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.statistics(PackageStatisticsSelector::downloadsTotalCount));
        values.add(selector.version("x", PackageVersionSelector::id));
        values.add(selector.versions(
                Paging.first(1),
                PackageVersionsFilterBuilder.builder()
                        .orderBy(PackageVersionOrderBuilder.builder().build())
                        .build(),
                PackageVersionSelector::id));
        return values;
    }

    private static List<Object> readWithoutArguments(final PackageSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.versions(Paging.first(1), PackageVersionSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PackageSelectorImpl(new RecordingCursor(root)));
        final PackageSelectorImpl selector =
                new PackageSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", "x", PackageType.DEBIAN, true, 1, "x", new Page<>(List.of("x"), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new PackageSelectorImpl(new RecordingCursor(root)));
        final PackageSelectorImpl selector =
                new PackageSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
