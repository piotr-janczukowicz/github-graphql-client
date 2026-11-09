package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsUploadsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseServerInstallationSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"customerName\":\"x\"" + "," + "\"hostName\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"isConnected\":true" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"userAccounts\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"userAccountsUploads\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final EnterpriseServerInstallationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.customerName());
        values.add(selector.hostName());
        values.add(selector.id());
        values.add(selector.isConnected());
        values.add(selector.updatedAt());
        values.add(selector.userAccounts(
                Paging.first(1),
                EnterpriseServerInstallationUserAccountsFilterBuilder.builder()
                        .orderBy(EnterpriseServerUserAccountOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseServerUserAccountOrderField.LOGIN)
                                .build())
                        .build(),
                EnterpriseServerUserAccountSelector::createdAt));
        values.add(selector.userAccountsUploads(
                Paging.first(1),
                EnterpriseServerInstallationUserAccountsUploadsFilterBuilder.builder()
                        .orderBy(EnterpriseServerUserAccountsUploadOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseServerUserAccountsUploadOrderField.CREATED_AT)
                                .build())
                        .build(),
                EnterpriseServerUserAccountsUploadSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseServerInstallationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.userAccounts(Paging.first(1), EnterpriseServerUserAccountSelector::createdAt));
        values.add(
                selector.userAccountsUploads(Paging.first(1), EnterpriseServerUserAccountsUploadSelector::createdAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseServerInstallationSelectorImpl(new RecordingCursor(root)));
        final EnterpriseServerInstallationSelectorImpl selector =
                new EnterpriseServerInstallationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseServerInstallationSelectorImpl(new RecordingCursor(root)));
        final EnterpriseServerInstallationSelectorImpl selector =
                new EnterpriseServerInstallationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null));
    }
}
