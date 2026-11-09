package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DependencyGraphDependencySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DependencyGraphManifestSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"blobPath\":\"x\"" + ","
            + "\"dependencies\":{\"nodes\": [{\"hasDependencies\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"dependenciesCount\":1" + "," + "\"exceedsMaxSize\":true" + "," + "\"filename\":\"x\"" + ","
            + "\"id\":\"x\"" + "," + "\"parseable\":true" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final DependencyGraphManifestSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.blobPath());
        values.add(selector.dependencies(Paging.first(1), DependencyGraphDependencySelector::hasDependencies));
        values.add(selector.dependenciesCount());
        values.add(selector.exceedsMaxSize());
        values.add(selector.filename());
        values.add(selector.id());
        values.add(selector.parseable());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DependencyGraphManifestSelectorImpl(new RecordingCursor(root)));
        final DependencyGraphManifestSelectorImpl selector =
                new DependencyGraphManifestSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", new Page<>(List.of(true), false, null), 1, true, "x", "x", true, true);
    }
}
