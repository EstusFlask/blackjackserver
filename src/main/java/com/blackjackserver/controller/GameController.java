package com.blackjackserver.controller;

import com.blackjackserver.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    private GameService gameService;
    private boolean gameOver = true;

    @PostMapping("/start")
    public GameState startGame() {
        gameService = new GameService();
        gameOver = false;
        return currentState("New game started.", null);
    }

    @PostMapping("/hit")
    public ResponseEntity<GameState> hit() {
        if (gameService == null || gameOver) {
            return ResponseEntity.badRequest().body(noActiveGameState());
        }

        gameService.hit();
        if (gameService.getPlayerCount() > 21) {
            gameOver = true;
            return ResponseEntity.ok(currentState("Player busted. Start a new game.", "lost"));
        }

        return ResponseEntity.ok(currentState("Player hit.", null));
    }

    @PostMapping("/stand")
    public ResponseEntity<GameState> stand() {
        if (gameService == null || gameOver) {
            return ResponseEntity.badRequest().body(noActiveGameState());
        }

        int result = gameService.stand();
        gameOver = true;
        return ResponseEntity.ok(currentState("Game ended. Start a new game.", resultName(result)));
    }

    private GameState currentState(String message, String result) {
        return new GameState(
                message,
                gameOver,
                result,
                gameService.getPlayerHand(),
                gameService.getPlayerCount(),
                gameService.getDealerHand(),
                gameService.getDealerCount()
        );
    }

    private GameState noActiveGameState() {
        return new GameState(
                "No active game. Start a new game first.",
                true,
                null,
                null,
                0,
                null,
                0
        );
    }

    private String resultName(int result) {
        if (result == 1) {
            return "won";
        }
        if (result == 2) {
            return "lost";
        }
        return "draw";
    }

    public record GameState(
            String message,
            boolean gameOver,
            String result,
            String playerHand,
            int playerScore,
            String dealerHand,
            int dealerScore
    ) {
    }
}
