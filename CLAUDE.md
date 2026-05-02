# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
mvn compile

# Run the application
mvn exec:java

# Package
mvn package

# Clean build artifacts
mvn clean
```

## Architecture

This is a minimal **Spring Core 6.2.6 / Java 17** project demonstrating XML-based dependency injection — no Spring Boot, no annotations.

**Wiring flow:**
1. `applicationContext.xml` declares the `hello` bean and injects `message` via a `<property>` tag.
2. `App.java` bootstraps the container with `ClassPathXmlApplicationContext`, retrieves the bean by ID, calls `greet()`, then closes the context.
3. `Hello.java` is a plain POJO with a setter — Spring sets `message` at startup via setter injection.

New beans belong in `applicationContext.xml`; new classes belong in `src/main/java/com/example/hello/`.

## GitHub Actions

Two workflows run via `anthropics/claude-code-action@v1`, both requiring the `CLAUDE_CODE_OAUTH_TOKEN` secret.

| Workflow | Trigger | What it does |
|---|---|---|
| `claude.yml` | Issue/PR comment or review containing `@claude` | Claude responds to the comment and acts on instructions |
| `claude-code-review.yml` | PR opened, updated, or reopened | Claude automatically reviews the PR using the `code-review` plugin |

To invoke Claude on a PR or issue, mention `@claude` in a comment.
