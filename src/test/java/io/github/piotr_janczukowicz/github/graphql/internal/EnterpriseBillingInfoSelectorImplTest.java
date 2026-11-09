package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class EnterpriseBillingInfoSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"allLicensableUsersCount\":1" + "," + "\"assetPacks\":1" + ","
            + "\"bandwidthQuota\":1.5" + "," + "\"bandwidthUsage\":1.5" + "," + "\"bandwidthUsagePercentage\":1" + ","
            + "\"storageQuota\":1.5" + "," + "\"storageUsage\":1.5" + "," + "\"storageUsagePercentage\":1" + ","
            + "\"totalAvailableLicenses\":1" + "," + "\"totalLicenses\":1" + "}";

    private static List<Object> readWithArguments(final EnterpriseBillingInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.allLicensableUsersCount());
        values.add(selector.assetPacks());
        values.add(selector.bandwidthQuota());
        values.add(selector.bandwidthUsage());
        values.add(selector.bandwidthUsagePercentage());
        values.add(selector.storageQuota());
        values.add(selector.storageUsage());
        values.add(selector.storageUsagePercentage());
        values.add(selector.totalAvailableLicenses());
        values.add(selector.totalLicenses());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseBillingInfoSelectorImpl(new RecordingCursor(root)));
        final EnterpriseBillingInfoSelectorImpl selector =
                new EnterpriseBillingInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, 1, 1.5, 1.5, 1, 1.5, 1.5, 1, 1, 1);
    }
}
