package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationsHovercardContextRelevantOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class OrganizationsHovercardContextSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"message\":\"x\"" + "," + "\"octicon\":\"x\"" + ","
            + "\"relevantOrganizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"totalOrganizationCount\":1" + "}";

    private static List<Object> readWithArguments(final OrganizationsHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.message());
        values.add(selector.octicon());
        values.add(selector.relevantOrganizations(
                Paging.first(1),
                OrganizationsHovercardContextRelevantOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.totalOrganizationCount());
        return values;
    }

    private static List<Object> readWithoutArguments(final OrganizationsHovercardContextSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.relevantOrganizations(Paging.first(1), OrganizationSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new OrganizationsHovercardContextSelectorImpl(new RecordingCursor(root)));
        final OrganizationsHovercardContextSelectorImpl selector =
                new OrganizationsHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", new Page<>(List.of(true), false, null), 1);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new OrganizationsHovercardContextSelectorImpl(new RecordingCursor(root)));
        final OrganizationsHovercardContextSelectorImpl selector =
                new OrganizationsHovercardContextSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null));
    }
}
