package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RerequestCheckSuitePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RerequestCheckSuitePayload}; used by the generated selection code only. */
final class RerequestCheckSuitePayloadSelectorImpl implements RerequestCheckSuitePayloadSelector {

    private final Cursor cursor;

    RerequestCheckSuitePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R checkSuite(final Function<CheckSuiteSelector, R> selection) {
        return cursor.object("checkSuite", child -> selection.apply(new CheckSuiteSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
