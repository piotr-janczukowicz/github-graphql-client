package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class StripeConnectAccountSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"accountId\":\"x\"" + "," + "\"billingCountryOrRegion\":\"x\"" + ","
            + "\"countryOrRegion\":\"x\"" + "," + "\"isActive\":true" + ","
            + "\"sponsorsListing\":{\"billingCountryOrRegion\": \"x\"}" + "," + "\"stripeDashboardUrl\":\"x\"" + "}";

    private static List<Object> readWithArguments(final StripeConnectAccountSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.accountId());
        values.add(selector.billingCountryOrRegion());
        values.add(selector.countryOrRegion());
        values.add(selector.isActive());
        values.add(selector.sponsorsListing(SponsorsListingSelector::billingCountryOrRegion));
        values.add(selector.stripeDashboardUrl());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StripeConnectAccountSelectorImpl(new RecordingCursor(root)));
        final StripeConnectAccountSelectorImpl selector =
                new StripeConnectAccountSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", true, "x", "x");
    }
}
