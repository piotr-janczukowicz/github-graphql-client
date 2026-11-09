package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LicenseRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code License}; used by the generated selection code only. */
final class LicenseSelectorImpl implements LicenseSelector {

    private final Cursor cursor;

    LicenseSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public <R> List<R> conditions(final Function<LicenseRuleSelector, R> selection) {
        return cursor.listRequired("conditions", child -> selection.apply(new LicenseRuleSelectorImpl(child)));
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public boolean featured() {
        return cursor.getRequired("featured", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hidden() {
        return cursor.getRequired("hidden", ScalarType.BOOLEAN);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String implementation() {
        return cursor.get("implementation", ScalarType.STRING);
    }

    @Override
    public String key() {
        return cursor.getRequired("key", ScalarType.STRING);
    }

    @Override
    public <R> List<R> limitations(final Function<LicenseRuleSelector, R> selection) {
        return cursor.listRequired("limitations", child -> selection.apply(new LicenseRuleSelectorImpl(child)));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String nickname() {
        return cursor.get("nickname", ScalarType.STRING);
    }

    @Override
    public <R> List<R> permissions(final Function<LicenseRuleSelector, R> selection) {
        return cursor.listRequired("permissions", child -> selection.apply(new LicenseRuleSelectorImpl(child)));
    }

    @Override
    public boolean pseudoLicense() {
        return cursor.getRequired("pseudoLicense", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String spdxId() {
        return cursor.get("spdxId", ScalarType.STRING);
    }

    @Override
    public @Nullable String url() {
        return cursor.get("url", ScalarType.STRING);
    }
}
