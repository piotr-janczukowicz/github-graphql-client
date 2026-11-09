module io.github.piotr_janczukowicz.graphqlclient {
    requires transitive io.github.piotr_janczukowicz.githubclient;
    requires static org.jspecify;
    requires static io.soabase.recordbuilder.core;
    requires static java.compiler;

    exports io.github.piotr_janczukowicz.github.graphql;
    exports io.github.piotr_janczukowicz.github.graphql.model;
}
