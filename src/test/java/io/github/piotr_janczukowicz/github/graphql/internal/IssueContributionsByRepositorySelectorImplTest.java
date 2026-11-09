package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class IssueContributionsByRepositorySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"contributions\":{\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final IssueContributionsByRepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contributions(
                Paging.first(1),
                IssueContributionsByRepositoryContributionsFilterBuilder.builder()
                        .orderBy(ContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .build())
                        .build(),
                CreatedIssueContributionSelector::isRestricted));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    private static List<Object> readWithoutArguments(final IssueContributionsByRepositorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.contributions(Paging.first(1), CreatedIssueContributionSelector::isRestricted));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new IssueContributionsByRepositorySelectorImpl(new RecordingCursor(root)));
        final IssueContributionsByRepositorySelectorImpl selector =
                new IssueContributionsByRepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null), true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new IssueContributionsByRepositorySelectorImpl(new RecordingCursor(root)));
        final IssueContributionsByRepositorySelectorImpl selector =
                new IssueContributionsByRepositorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null));
    }
}
