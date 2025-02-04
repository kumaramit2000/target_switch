package com.phonepe.battleShipGame.controllers;

import com.phonepe.battleShipGame.services.BattleShipGameService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/game")
public class BattleShipGameController {
    private static final Logger logger = LoggerFactory.getLogger(BattleShipGameService.class);
    private final BattleShipGameService gameService;

    public BattleShipGameController(BattleShipGameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("/initGame/{size}")
    public String initGame(@PathVariable int size) {
        gameService.initGame(size);
        return "Game initialized with battlefield size: " + size;
    }

    @GetMapping("/addShip")
    public String addShip(@RequestParam String id, @RequestParam int size,
                          @RequestParam int xA, @RequestParam int yA,
                          @RequestParam int xB, @RequestParam int yB) {
        try {
            gameService.addShip(id, size, xA, yA, xB, yB);
            return "Ship " + id + " added successfully!";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/startGame")
    public String startGame() {
        System.out.println("Game Started!");
        gameService.startGame();
        return "Game Over!";
    }

    /**
     * Optional - API - Implemented *****
     */
    @GetMapping("/viewBattleField")
    public String viewBattleField(){
        System.out.println(gameService.viewBattleField());
        return gameService.viewBattleField();
    }
}