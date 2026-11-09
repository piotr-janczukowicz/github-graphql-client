package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RecordingCursorTest {

    @Test
    void scalarListRequired_shouldRecordTheFieldAndReturnOnePlaceholder_whenRecording() {
        final FieldSelection root = FieldSelection.root();
        final RecordingCursor cursor = new RecordingCursor(root);

        final List<String> values = cursor.scalarListRequired("values", ScalarType.STRING);

        assertSoftly(softly -> {
            softly.assertThat(values).containsExactly("");
            softly.assertThat(root.child("values")).isNotNull();
        });
    }

    @Test
    void scalarList_shouldRecordTheFieldAndReturnOnePlaceholder_whenRecording() {
        final FieldSelection root = FieldSelection.root();
        final RecordingCursor cursor = new RecordingCursor(root);

        final List<Integer> values = cursor.scalarList("values", ScalarType.INT);

        assertSoftly(softly -> {
            softly.assertThat(values).containsExactly(0);
            softly.assertThat(root.child("values")).isNotNull();
        });
    }

    @Test
    void branch_shouldRecordTheTypenameAndTheFragment_whenTheBranchReadsAField() {
        final FieldSelection root = FieldSelection.root();
        final RecordingCursor cursor = new RecordingCursor(root);

        final String login = cursor.branch("User", child -> child.getRequired("login", ScalarType.STRING));

        assertSoftly(softly -> {
            softly.assertThat(login).isEmpty();
            softly.assertThat(root.child("__typename")).isNotNull();
            softly.assertThat(QueryWriter.write(root).text()).isEqualTo("query{__typename ... on User{login}}");
        });
    }

    @Test
    void branch_shouldMergeTheFragment_whenTheSameTypeIsReadTwice() {
        final FieldSelection root = FieldSelection.root();
        final RecordingCursor cursor = new RecordingCursor(root);

        cursor.branch("User", child -> child.getRequired("login", ScalarType.STRING));
        cursor.branch("User", child -> child.getRequired("name", ScalarType.STRING));

        assertThat(QueryWriter.write(root).text()).isEqualTo("query{__typename ... on User{login name}}");
    }

    @Test
    void branch_shouldFail_whenTheBranchReadsNoField() {
        final RecordingCursor cursor = new RecordingCursor(FieldSelection.root());

        final Throwable thrown = catchThrowable(() -> cursor.branch("User", child -> "nothing"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("... on User");
    }
}
