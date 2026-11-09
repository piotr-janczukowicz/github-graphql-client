package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CommentAuthorAssociationTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CommentAuthorAssociation commentAuthorAssociation = CommentAuthorAssociation.fromWire("COLLABORATOR");

        assertThat(commentAuthorAssociation).isEqualTo(CommentAuthorAssociation.COLLABORATOR);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CommentAuthorAssociation commentAuthorAssociation = CommentAuthorAssociation.fromWire("NOT_A_VALUE");

        assertThat(commentAuthorAssociation).isEqualTo(CommentAuthorAssociation.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CommentAuthorAssociation.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
