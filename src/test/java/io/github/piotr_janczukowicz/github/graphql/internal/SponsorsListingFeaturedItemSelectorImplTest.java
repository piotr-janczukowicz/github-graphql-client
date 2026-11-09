package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SponsorsListingFeaturedItemSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"description\":\"x\"" + ","
            + "\"featureable\":{\"__typename\": \"Repository\", \"allowUpdateBranch\": true}" + "," + "\"id\":\"x\""
            + "," + "\"position\":1" + "," + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final SponsorsListingFeaturedItemSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.featureable(
                child -> child.on(RepositorySelector.class, RepositorySelector::allowUpdateBranch)));
        values.add(selector.id());
        values.add(selector.position());
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SponsorsListingFeaturedItemSelectorImpl(new RecordingCursor(root)));
        final SponsorsListingFeaturedItemSelectorImpl selector =
                new SponsorsListingFeaturedItemSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x",
                        true,
                        "x",
                        1,
                        "x",
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
