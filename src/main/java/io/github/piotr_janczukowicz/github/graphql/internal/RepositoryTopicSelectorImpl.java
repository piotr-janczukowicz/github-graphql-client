package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryTopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code RepositoryTopic}; used by the generated selection code only. */
final class RepositoryTopicSelectorImpl implements RepositoryTopicSelector {

    private final Cursor cursor;

    RepositoryTopicSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> R topic(final Function<TopicSelector, R> selection) {
        return cursor.objectRequired("topic", child -> selection.apply(new TopicSelectorImpl(child)));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
