package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class QueryWriterTest {

    @Test
    void write_shouldSuffixTheVariableName_whenTwoArgumentsShareAName() {
        final FieldSelection root = FieldSelection.root();
        root.select("first", List.of(Argument.of("id", "ID!", "1")));
        root.select("second", List.of(Argument.of("id", "ID!", "2")));

        final QueryDocument document = QueryWriter.write(root);

        assertSoftly(softly -> {
            softly.assertThat(document.text()).isEqualTo("query($id:ID!,$id2:ID!){first(id:$id) second(id:$id2)}");
            softly.assertThat(document.variables()).containsEntry("id", "1").containsEntry("id2", "2");
        });
    }

    @Test
    void write_shouldOmitTheArgumentAndTheVariables_whenTheValueIsNull() {
        final FieldSelection root = FieldSelection.root();
        root.select("field", List.of(Argument.of("first", "Int", null)));

        final QueryDocument document = QueryWriter.write(root);

        assertSoftly(softly -> {
            softly.assertThat(document.text()).isEqualTo("query{field}");
            softly.assertThat(document.variables()).isEmpty();
        });
    }

    @Test
    void write_shouldStartWithTheOperationKeyword_whenTheRootIsAMutation() {
        final FieldSelection root = FieldSelection.root("mutation");
        root.select("add", List.of(Argument.of("input", "In!", "x")));

        final QueryDocument document = QueryWriter.write(root);

        assertThat(document.text()).isEqualTo("mutation($input:In!){add(input:$input)}");
    }
}
