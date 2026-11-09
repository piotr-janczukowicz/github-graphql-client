package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Actor}. */
public interface ActorSelector {

    String avatarUrl(ActorAvatarUrlFilter arguments);

    String avatarUrl();

    String login();

    String resourcePath();

    String url();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
