# Demo

A small Spring Boot web app that serves a static homepage and a sign-in page. It is a starting point: the pages and routes are in place, and the behaviour behind them is intentionally minimal.

**Author:** Zinah

## Features

- **Homepage** at `/` (`src/main/resources/static/index.html`), a static page served directly by Spring Boot.
- **Sign-in page** at `/login` (`src/main/resources/static/login.html`), a form that asks for an email and a password.
- **Login handling** in `LoginController`:
  - `GET /login` shows the sign-in page.
  - `POST /login` checks that both fields are non-blank. If either is missing it redirects to `/login?error=missing`, which shows an error banner. Otherwise it redirects to `/login?sent=1`, which shows a confirmation message.

> **Note:** the sign-in flow does not authenticate anyone. It stores no credentials and opens no session. It only validates that the fields are filled in.

## Requirements

- JDK 17 (the build uses a Java 17 toolchain; Gradle can download one if your setup allows it)
- An internet connection on first build, to fetch dependencies and the Gradle distribution
- No database is needed to run the app as it is now (see [Database](#database))

The Gradle wrapper is included, so a separate Gradle install is not required.

## Getting started

Clone the repository and move into the project directory, then run:

```bash
./gradlew bootRun        # macOS / Linux
gradlew.bat bootRun      # Windows
```

Open <http://localhost:8080> in your browser.

| Path      | What you get                        |
| --------- | ----------------------------------- |
| `/`       | Homepage                            |
| `/login`  | Sign-in form                        |

To build a runnable jar:

```bash
./gradlew build
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

## Running tests

```bash
./gradlew test
```

The only existing test, `DemoApplicationTests`, starts the full application context (`contextLoads`) to confirm that it boots.

## Project structure

```
.
├── build.gradle                 # Build config: Spring Boot, Java 17, dependencies
├── settings.gradle              # Project name ("demo")
├── gradlew / gradlew.bat        # Gradle wrapper scripts
├── gradle/wrapper/              # Wrapper configuration (Gradle 9.8.2)
└── src
    ├── main
    │   ├── java/com/example/demo
    │   │   ├── DemoApplication.java     # Entry point (@SpringBootApplication)
    │   │   └── LoginController.java     # GET and POST /login
    │   └── resources
    │       ├── application.properties   # Sets spring.application.name=demo
    │       └── static
    │           ├── index.html           # Homepage
    │           └── login.html           # Sign-in page (HTML, CSS, and a small script)
    └── test
        └── java/com/example/demo
            └── DemoApplicationTests.java
```

## Configuration

`src/main/resources/application.properties` currently contains only:

```properties
spring.application.name=demo
```

The server uses Spring Boot's defaults, including port `8080`. To change the port, add `server.port=<port>` to this file.

## Database

`build.gradle` includes the PostgreSQL driver as a runtime dependency, but no datasource is configured and no code uses a database. Add the connection settings (for example `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password`) when you are ready to store data.

## Dependencies and versions

- Spring Boot `4.2.0-SNAPSHOT`, from the Spring snapshot repository (`https://repo.spring.io/snapshot`). Snapshot builds can change, so builds may not be reproducible over time. Switch to a released Spring Boot version when one suits your needs.
- `spring-boot-starter-webmvc` for the web layer
- `org.postgresql:postgresql` (runtime only)
- Test: `spring-boot-starter-webmvc-test` and JUnit Platform

## Front-end notes

Both pages are self-contained HTML files with inline CSS. They load the **Fraunces** and **Outfit** fonts from Google Fonts, so the fonts need an internet connection. Without one, the pages fall back to system serif and sans-serif fonts.

## Further reference

`HELP.md` lists the Spring Boot and Gradle reference documentation that the project was generated with.
