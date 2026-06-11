package com.blackjackserver.controller;

import com.blackjackserver.service.GameService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/games")
public class GameController {
    private Map<Long, BlackjackGame> games = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    @PostMapping
    public Long createGame() {
        long id = idCounter.incrementAndGet();
        games.put(id, new BlackjackGame());
        return id; // 返回游戏ID
    }

    @PostMapping("/{id}/hit")
    public String hit(@PathVariable Long id) {
        BlackjackGame game = games.get(id);
        if (game == null) return "游戏不存在";
        game.playerHit();
        return game.getStatus();
    }

    @PostMapping("/{id}/stand")
    public String stand(@PathVariable Long id) {
        BlackjackGame game = games.get(id);
        if (game == null) return "游戏不存在";
        game.playerStand();
        return game.getStatus();
    }

    @GetMapping("/{id}")
    public String getStatus(@PathVariable Long id) {
        BlackjackGame game = games.get(id);
        if (game == null) return "游戏不存在";
        return game.getStatus();
    }
}
