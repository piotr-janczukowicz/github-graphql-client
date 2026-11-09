# github-graphql-client

Typed Java 21 client for the GitHub GraphQL API. A query is a lambda over generated selectors, so a field you did not
select cannot be read, and the query sent contains exactly the fields the lambda reads.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.piotr-janczukowicz/github-graphql-client)](https://central.sonatype.com/artifact/io.github.piotr-janczukowicz/github-graphql-client)
![Java 21](https://img.shields.io/badge/Java-21-orange.svg)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Build](https://github.com/piotr-janczukowicz/github-graphql-client/actions/workflows/main.yml/badge.svg)](https://github.com/piotr-janczukowicz/github-graphql-client/actions/workflows/main.yml)
[![Codacy Coverage](https://app.codacy.com/project/badge/Coverage/442e561e5ad4445a9dea73ac3185cb60)](https://app.codacy.com/gh/piotr-janczukowicz/github-graphql-client/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_coverage)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/442e561e5ad4445a9dea73ac3185cb60)](https://app.codacy.com/gh/piotr-janczukowicz/github-graphql-client/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

## Why this library

- **Generated from GitHub's own schema.** The selectors, enums and input records are built from the
  [published GraphQL schema](https://docs.github.com/en/graphql), so every type and field GitHub documents has a typed
  counterpart.
- **You fetch what you read.** A query is a lambda over the selectors: the query sent contains exactly the fields the
  lambda reads, and a field you did not select cannot be read.
- **Safe when GitHub adds values.** An enum value the library does not know reads as `UNRECOGNIZED` instead of throwing,
  so a new value on GitHub's side does not break your code.
- **The boring parts are handled.** Authentication, retries and rate limits come from
  [github-client](https://github.com/piotr-janczukowicz/github-client), pages are followed lazily as a `Stream`, and a
  failed query is a typed exception that carries GitHub's errors.
- **Small on purpose.** Synchronous queries and mutations on github.com and GitHub Enterprise Cloud: no async API, and
  GitHub Enterprise Server is not covered yet.

## Install

**Requirements:** Java 21. The library is a Java module, `io.github.piotr_janczukowicz.graphqlclient`, and also works on
the class path. It is published on
[Maven Central](https://central.sonatype.com/artifact/io.github.piotr-janczukowicz/github-graphql-client):

```xml
<dependency>
    <groupId>io.github.piotr-janczukowicz</groupId>
    <artifactId>github-graphql-client</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

Replace `LATEST_VERSION` with the version in the Maven Central badge at the top of this page, or with the newest entry on
the [releases page](https://github.com/piotr-janczukowicz/github-graphql-client/releases).

## Quick start

```java
record Info(String name, int stars, String owner) {}

try (GitHubClient client = GitHubClients.create(AuthenticationProviders.bearer(token), "my-app/1.0")) {
    final GitHubGraphQL graphql = GitHubGraphQL.of(client);

    final Info info = graphql.query(query -> query.repository("octocat", "Hello-World", repository ->
            new Info(repository.name(), repository.stargazerCount(), repository.owner(owner -> owner.login()))));
}
```

The query sent is
`query($owner:String!,$name:String!){repository(owner:$owner,name:$name){name stargazerCount owner{login}}}`, built from
the fields the lambda reads.

## Lists and pages

A connection is read as a typed `Page`. `null` entries that GitHub sends for items you may not see are skipped:

```java
final Page<String> page = graphql.query(query -> query.repository("o", "n", repository ->
        repository.issues(Paging.first(2), issue -> issue.title())));

final Page<String> next = graphql.query(query -> query.repository("o", "n", repository ->
        repository.issues(Paging.first(2).after(page.endCursor()), issue -> issue.title())));
```

`Page` has `items()`, `hasNext()` and `endCursor()`. The client adds `pageInfo { hasNextPage endCursor }` itself, and
`Paging.first(n)` accepts 1 to 100. Backward paging (`before` and `last`) is not offered.

## Arguments, enums and dates

A field's required arguments are plain parameters. Its optional ones go into a generated record with a builder, such as
`RepositoryIssuesFilterBuilder`. Without any optional argument there is a short form, such as
`repository.issues(Paging.first(2), issue -> issue.title())`.

An enum field returns a generated enum, a `DateTime` field an `Instant`, and a `URI` field a `String`.

```java
record IssueView(IssueState state, Instant createdAt, String url) {}

final List<IssueView> openBugs = graphql.query(query -> query.repository("o", "n", repository ->
        repository.issues(
                RepositoryIssuesFilterBuilder.builder().first(10).labels(List.of("bug"))
                        .states(List.of(IssueState.OPEN)).build(), connection ->
                connection.nodes(issue -> new IssueView(issue.state(), issue.createdAt(), issue.url())))));
```

- **`UNRECOGNIZED`:** every generated enum has this extra constant. A value that GitHub adds later reads as
  `UNRECOGNIZED`, so an older version keeps working. Sending it as an argument fails before the request is sent.
- **Lists:** an empty list is sent as an empty list, and `null` leaves the argument out. A list with a `null` element
  fails when the argument record is built.
- **Parsing:** a value that cannot be parsed, such as an invalid date, fails with the path of the field.

## Input objects and mutations

An input object is a generated record with a builder. It goes into the arguments like any other value:

```java
final Stream<String> titles = graphql.paginate((query, paging) -> query.repository("o", "n", repository ->
        repository.issues(paging,
                RepositoryIssuesFilterBuilder.builder()
                        .filterBy(IssueFiltersBuilder.builder().assignee("octocat").states(List.of(IssueState.OPEN)).build())
                        .orderBy(IssueOrderBuilder.builder().direction(OrderDirection.DESC).field(IssueOrderField.CREATED_AT).build())
                        .build(),
                issue -> issue.title())));

final AddCommentPayload input = AddCommentPayloadBuilder.builder().subjectId("I_1").body("Thanks!").build();
final String id = graphql.mutate(mutation -> mutation.addComment(input, payload ->
        payload.commentEdge(edge -> edge.node(comment -> comment.id()))));
```

`mutate` works like `query`, but the request is sent once and is never paged. The client does not retry a mutation
after a read error or a server error, because it could have taken effect. Every input record has `toVariable()`, the map
GraphQL receives.

## Interfaces and unions

A field that returns an interface, such as `Actor`, has the shared fields on its selector. A union has none. Both are
narrowed with `on`, which writes `... on User { ... }` and returns `null` when the object is another type:

```java
final List<String> authors = graphql.paginate((query, paging) -> query.repository("o", "n", repository ->
        repository.issues(paging, issue -> issue.author(actor -> {
            final String name = actor.on(UserSelector.class, user -> user.name());   // null for a bot
            return actor.login() + (name == null ? "" : " (" + name + ")");
        })))).toList();
```

Read every branch first and choose afterwards. A class that is not a possible type of the selector fails with
`IllegalArgumentException`.

## Auto-paging

`paginate` reads every page of one connection as a lazy `Stream` of items. The selection gets the `Paging` to use for
each page and must return the page itself:

```java
final Stream<String> titles = graphql.paginate((query, paging) ->
        query.repository("o", "n", repository -> repository.issues(paging, issue -> issue.title())));

final List<String> firstTwenty = graphql.paginate(Paging.first(10), (query, paging) ->
        query.repository("o", "n", repository -> repository.issues(paging, issue -> issue.title())))
        .limit(20).toList();                                     // stops fetching after two pages
```

A page is fetched only when the stream needs its first item. The page size is the client's `pagination().perPage()`
unless you pass a `Paging`. Reading more pages than the client's `maxPages` fails with
`GitHubPaginationLimitExceededException`, a repeating cursor with `GitHubPaginationLoopException`, and a failed request
with `UncheckedIOException`.

## Readable queries

The lambda runs twice: once to record the fields it reads and once to map the response. It must not have side effects.

Every object you open is one more lambda. Keep the query at two levels and give each deeper object a named method that
takes its selector and returns your record:

```java
record IssueView(String title, IssueState state, String author, List<String> labels) {}

static IssueView issueView(final IssueSelector issue) {
    return new IssueView(
            issue.title(),
            issue.state(),
            issue.author(IssueViews::authorName),
            issue.labels(Paging.first(5), LabelSelector::name).items());
}

static String authorName(final ActorSelector actor) {
    final String name = actor.on(UserSelector.class, user -> user.name());
    return actor.login() + (name == null ? "" : " (" + name + ")");
}

final Stream<IssueView> issues = graphql.paginate((query, paging) ->
        query.repository("o", "n", repository -> repository.issues(paging, IssueViews::issueView)));
```

`IssueViews` stands for your own class. The same `issueView` serves every query that lists issues.

## Disclaimer

This library is generated from the GraphQL schema that GitHub publishes, and the caveats of that schema apply here too.

**Only smoke tests have been run on the live GitHub environment, covering particular queries and mutations. Not every
type, field or mutation has been tested. This library is new and not yet proven in production, and is meant to surface
errors in the schema and the code. Verify the behavior of any query you depend on before using it in production.**

## License

[MIT](LICENSE)
