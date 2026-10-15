# Blackjack Server

A minimal Java / Spring Boot REST API prototype for a single blackjack game. The game state is held in memory by the controller.

简易二十一点 REST API 原型，使用 Java 与 Spring Boot，提供开局、要牌和停牌接口。

## Run from source

The Gradle build declares a Java 17 toolchain. Use a JDK compatible with the Spring Boot version declared in [`build.gradle`](build.gradle).

```powershell
.\gradlew.bat bootRun
```

On macOS or Linux:

```bash
./gradlew bootRun
```

The application uses Spring Boot's default HTTP port, `8080`, unless overridden in your environment.

## API

All endpoints use `POST` and take no request body.

| Endpoint | Action |
| --- | --- |
| `/game/start` | Create a game and return its initial state |
| `/game/hit` | Draw a card for the player |
| `/game/stand` | Compare scores and finish the game |

```bash
curl -X POST http://localhost:8080/game/start
curl -X POST http://localhost:8080/game/hit
curl -X POST http://localhost:8080/game/stand
```

Responses include `message`, `gameOver`, `result`, player/dealer hands, and player/dealer scores. Calling `hit` or `stand` without an active game returns HTTP 400.

## Scope

This is a learning prototype. The controller shares one in-memory game across requests; it does not provide separate player sessions, persistence, or a complete casino rules engine. See [`GameController.java`](src/main/java/com/blackjackserver/controller/GameController.java) and [`GameService.java`](src/main/java/com/blackjackserver/service/GameService.java) for the implemented behavior.
