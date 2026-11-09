package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class DependencyGraphDependencySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"hasDependencies\":true" + "," + "\"packageLabel\":\"x\"" + "," + "\"packageManager\":\"x\"" + ","
                    + "\"packageName\":\"x\"" + "," + "\"packageUrl\":\"x\"" + "," + "\"relationship\":\"x\"" + ","
                    + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"requirements\":\"x\"" + "}";

    private static List<Object> readWithArguments(final DependencyGraphDependencySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.hasDependencies());
        values.add(selector.packageLabel());
        values.add(selector.packageManager());
        values.add(selector.packageName());
        values.add(selector.packageUrl());
        values.add(selector.relationship());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.requirements());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DependencyGraphDependencySelectorImpl(new RecordingCursor(root)));
        final DependencyGraphDependencySelectorImpl selector =
                new DependencyGraphDependencySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", "x", "x", "x", "x", true, "x");
    }
}
