package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewBattleFieldServiceTest {

    private BattleShipGameService gameService;
    private ShipService shipService;
    private ViewBattleFieldService viewBattleFieldService;

    @BeforeEach
    void setUp() {
        Battlefield battlefield = new Battlefield();
        gameService = new BattleShipGameService(battlefield);
        shipService = new ShipService(battlefield);
        viewBattleFieldService = new ViewBattleFieldService(battlefield);
    }


    // Viewing battlefield displays correct grid
    @Test
    void testViewBattlefield() {
        gameService.initGame(6);
        shipService.addShip("SH1", 2, 1, 2, 4, 3);
        String battlefieldView = viewBattleFieldService.viewBattleField();
        assertNotNull(battlefieldView);
        assertTrue(battlefieldView.contains("A-SH1"));
        assertTrue(battlefieldView.contains("B-SH1"));
    }
}
