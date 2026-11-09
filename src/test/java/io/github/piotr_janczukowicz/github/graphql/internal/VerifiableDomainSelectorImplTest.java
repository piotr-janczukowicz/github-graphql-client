package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class VerifiableDomainSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1"
            + "," + "\"dnsHostName\":\"x\"" + "," + "\"domain\":\"x\"" + "," + "\"hasFoundHostName\":true" + ","
            + "\"hasFoundVerificationToken\":true" + "," + "\"id\":\"x\"" + "," + "\"isApproved\":true" + ","
            + "\"isRequiredForPolicyEnforcement\":true" + "," + "\"isVerified\":true" + ","
            + "\"owner\":{\"__typename\": \"Enterprise\", \"avatarUrl\": \"x\"}" + ","
            + "\"punycodeEncodedDomain\":\"x\"" + "," + "\"tokenExpirationTime\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"verificationToken\":\"x\"" + "}";

    private static List<Object> readWithArguments(final VerifiableDomainSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.dnsHostName());
        values.add(selector.domain());
        values.add(selector.hasFoundHostName());
        values.add(selector.hasFoundVerificationToken());
        values.add(selector.id());
        values.add(selector.isApproved());
        values.add(selector.isRequiredForPolicyEnforcement());
        values.add(selector.isVerified());
        values.add(selector.owner(child -> child.on(EnterpriseSelector.class, EnterpriseSelector::avatarUrl)));
        values.add(selector.punycodeEncodedDomain());
        values.add(selector.tokenExpirationTime());
        values.add(selector.updatedAt());
        values.add(selector.verificationToken());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new VerifiableDomainSelectorImpl(new RecordingCursor(root)));
        final VerifiableDomainSelectorImpl selector =
                new VerifiableDomainSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        true,
                        true,
                        "x",
                        true,
                        true,
                        true,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x");
    }
}
