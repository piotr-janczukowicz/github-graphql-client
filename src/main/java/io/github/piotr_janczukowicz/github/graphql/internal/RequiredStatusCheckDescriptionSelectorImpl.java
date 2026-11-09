package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AppSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredStatusCheckDescriptionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RequiredStatusCheckDescription}; used by the generated selection code only.
 */
final class RequiredStatusCheckDescriptionSelectorImpl implements RequiredStatusCheckDescriptionSelector {

    private final Cursor cursor;

    RequiredStatusCheckDescriptionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R app(final Function<AppSelector, R> selection) {
        return cursor.object("app", child -> selection.apply(new AppSelectorImpl(child)));
    }

    @Override
    public String context() {
        return cursor.getRequired("context", ScalarType.STRING);
    }
}
