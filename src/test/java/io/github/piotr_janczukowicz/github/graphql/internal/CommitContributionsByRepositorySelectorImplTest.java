package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedCommitContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CommitContributionsByRepositorySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"contributions\":{\"nodes\": [{\"commitCount\": 1}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CommitContributionsByRepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contributions(
                Paging.first(1),
                CommitContributionsByRepositoryContributionsFilterBuilder.builder()
                        .orderBy(CommitContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(CommitContributionOrderField.COMMIT_COUNT)
                                .build())
                        .build(),
                CreatedCommitContributionSelector::commitCount));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final CommitContributionsByRepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contributions(Paging.first(1), CreatedCommitContributionSelector::commitCount));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CommitContributionsByRepositorySelectorImpl(new RecordingCursor(root)));
        final CommitContributionsByRepositorySelectorImpl selector =
                new CommitContributionsByRepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(1), false, null), true, "x", "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new CommitContributionsByRepositorySelectorImpl(new RecordingCursor(root)));
        final CommitContributionsByRepositorySelectorImpl selector =
                new CommitContributionsByRepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(1), false, null));
    }
}
