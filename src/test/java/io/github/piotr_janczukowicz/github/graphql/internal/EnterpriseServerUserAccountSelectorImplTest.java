package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseServerUserAccountSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"emails\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"enterpriseServerInstallation\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"id\":\"x\""
            + "," + "\"isSiteAdmin\":true" + "," + "\"login\":\"x\"" + "," + "\"profileName\":\"x\"" + ","
            + "\"remoteCreatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"remoteUserId\":1" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final EnterpriseServerUserAccountSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.emails(
                Paging.first(1),
                EnterpriseServerUserAccountEmailsFilterBuilder.builder()
                        .orderBy(EnterpriseServerUserAccountEmailOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseServerUserAccountEmailOrderField.EMAIL)
                                .build())
                        .build(),
                EnterpriseServerUserAccountEmailSelector::createdAt));
        values.add(selector.enterpriseServerInstallation(EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.id());
        values.add(selector.isSiteAdmin());
        values.add(selector.login());
        values.add(selector.profileName());
        values.add(selector.remoteCreatedAt());
        values.add(selector.remoteUserId());
        values.add(selector.updatedAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseServerUserAccountSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.emails(Paging.first(1), EnterpriseServerUserAccountEmailSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseServerUserAccountSelectorImpl(new RecordingCursor(root)));
        final EnterpriseServerUserAccountSelectorImpl selector =
                new EnterpriseServerUserAccountSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseServerUserAccountSelectorImpl(new RecordingCursor(root)));
        final EnterpriseServerUserAccountSelectorImpl selector =
                new EnterpriseServerUserAccountSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
