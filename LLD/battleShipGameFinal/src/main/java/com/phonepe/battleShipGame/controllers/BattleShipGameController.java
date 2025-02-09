package com.phonepe.battleShipGame.controllers;

import com.phonepe.battleShipGame.services.BattleService;
import com.phonepe.battleShipGame.services.BattleShipGameService;
import com.phonepe.battleShipGame.services.ShipService;
import com.phonepe.battleShipGame.services.ViewBattleFieldService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/game")
public class BattleShipGameController {
    private static final Logger logger = LoggerFactory.getLogger(BattleShipGameController.class);
    private final BattleShipGameService gameService;
    private final ShipService shipService;
    private final BattleService battleService;
    private final ViewBattleFieldService viewBattleFieldService;

    public BattleShipGameController(BattleShipGameService gameService, ShipService shipService, BattleService battleService, ViewBattleFieldService viewBattleFieldService) {
        this.gameService = gameService;
        this.shipService = shipService;
        this.battleService = battleService;
        this.viewBattleFieldService = viewBattleFieldService;
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
            shipService.addShip(id, size, xA, yA, xB, yB);
            return "Ship " + id + " added successfully!";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/startGame")
    public String startGame() {
        System.out.println("Game Started!");
        battleService.startGame();
        return "Game Over!";
    }

    /**
     * Optional - API - Implemented *****
     */
    @GetMapping("/viewBattleField")
    public String viewBattleField(){
        System.out.println(viewBattleFieldService.viewBattleField());
        return viewBattleFieldService.viewBattleField();
    }
}