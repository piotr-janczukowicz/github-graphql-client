package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSyncState;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseServerUserAccountsUploadSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
                    + "\"enterpriseServerInstallation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"syncState\":\"FAILURE\"" + ","
                    + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final EnterpriseServerUserAccountsUploadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.enterpriseServerInstallation(EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.syncState());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseServerUserAccountsUploadSelectorImpl(new RecordingCursor(root)));
        final EnterpriseServerUserAccountsUploadSelectorImpl selector =
                new EnterpriseServerUserAccountsUploadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        EnterpriseServerUserAccountsUploadSyncState.FAILURE,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
