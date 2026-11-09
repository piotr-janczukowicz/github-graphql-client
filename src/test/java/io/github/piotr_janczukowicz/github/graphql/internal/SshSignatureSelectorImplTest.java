package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.GitSignatureState;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SshSignatureSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"email\":\"x\"" + "," + "\"isValid\":true" + ","
            + "\"keyFingerprint\":\"x\"" + "," + "\"payload\":\"x\"" + "," + "\"signature\":\"x\"" + ","
            + "\"signer\":{\"anyPinnableItems\": true}" + "," + "\"state\":\"BAD_CERT\"" + ","
            + "\"verifiedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"wasSignedByGitHub\":true" + "}";

    private static List<Object> readWithArguments(final SshSignatureSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.email());
        values.add(selector.isValid());
        values.add(selector.keyFingerprint());
        values.add(selector.payload());
        values.add(selector.signature());
        values.add(selector.signer(UserSelector::anyPinnableItems));
        values.add(selector.state());
        values.add(selector.verifiedAt());
        values.add(selector.wasSignedByGitHub());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SshSignatureSelectorImpl(new RecordingCursor(root)));
        final SshSignatureSelectorImpl selector =
                new SshSignatureSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        true,
                        "x",
                        "x",
                        "x",
                        true,
                        GitSignatureState.BAD_CERT,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        true);
    }
}
