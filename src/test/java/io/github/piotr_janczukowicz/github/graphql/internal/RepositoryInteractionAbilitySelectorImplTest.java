package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionLimit;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInteractionLimitOrigin;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryInteractionAbilitySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"expiresAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"limit\":\"COLLABORATORS_ONLY\"" + "," + "\"origin\":\"ORGANIZATION\"" + "}";

    private static List<Object> readWithArguments(final RepositoryInteractionAbilitySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.expiresAt());
        values.add(selector.limit());
        values.add(selector.origin());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryInteractionAbilitySelectorImpl(new RecordingCursor(root)));
        final RepositoryInteractionAbilitySelectorImpl selector =
                new RepositoryInteractionAbilitySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        RepositoryInteractionLimit.COLLABORATORS_ONLY,
                        RepositoryInteractionLimitOrigin.ORGANIZATION);
    }
}
