package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GitHubMetadataSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"gitHubServicesSha\":\"x\"" + "," + "\"gitIpAddresses\":[\"x\"]"
            + "," + "\"githubEnterpriseImporterIpAddresses\":[\"x\"]" + "," + "\"hookIpAddresses\":[\"x\"]" + ","
            + "\"importerIpAddresses\":[\"x\"]" + "," + "\"isPasswordAuthenticationVerifiable\":true" + ","
            + "\"pagesIpAddresses\":[\"x\"]" + "}";

    private static List<Object> readWithArguments(final GitHubMetadataSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.gitHubServicesSha());
        values.add(selector.gitIpAddresses());
        values.add(selector.githubEnterpriseImporterIpAddresses());
        values.add(selector.hookIpAddresses());
        values.add(selector.importerIpAddresses());
        values.add(selector.isPasswordAuthenticationVerifiable());
        values.add(selector.pagesIpAddresses());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GitHubMetadataSelectorImpl(new RecordingCursor(root)));
        final GitHubMetadataSelectorImpl selector =
                new GitHubMetadataSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", List.of("x"), List.of("x"), List.of("x"), List.of("x"), true, List.of("x"));
    }
}
