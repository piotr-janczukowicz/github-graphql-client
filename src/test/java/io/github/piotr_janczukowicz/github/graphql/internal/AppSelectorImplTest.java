package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AppIpAllowListEntriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AppLogoUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AppSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientId\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\""
            + "," + "\"databaseId\":1" + "," + "\"description\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"ipAllowListEntries\":{\"nodes\": [{\"allowListValue\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"logoBackgroundColor\":\"x\"" + "," + "\"logoUrl\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"slug\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "}";

    private static List<Object> readWithArguments(final AppSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientId());
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.ipAllowListEntries(
                Paging.first(1),
                AppIpAllowListEntriesFilterBuilder.builder()
                        .orderBy(IpAllowListEntryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(IpAllowListEntryOrderField.ALLOW_LIST_VALUE)
                                .build())
                        .build(),
                IpAllowListEntrySelector::allowListValue));
        values.add(selector.logoBackgroundColor());
        values.add(selector.logoUrl(AppLogoUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.name());
        values.add(selector.slug());
        values.add(selector.updatedAt());
        values.add(selector.url());
        return values;
    }

    private static List<Object> readWithoutArguments(final AppSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.ipAllowListEntries(Paging.first(1), IpAllowListEntrySelector::allowListValue));
        values.add(selector.logoUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AppSelectorImpl(new RecordingCursor(root)));
        final AppSelectorImpl selector = new AppSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new AppSelectorImpl(new RecordingCursor(root)));
        final AppSelectorImpl selector = new AppSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null), "x");
    }
}
