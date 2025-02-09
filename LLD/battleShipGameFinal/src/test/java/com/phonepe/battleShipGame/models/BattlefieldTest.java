package com.phonepe.battleShipGame.models;

import com.phonepe.battleShipGame.services.BattleShipGameService;
import com.phonepe.battleShipGame.services.ShipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlefieldTest {
    private BattleShipGameService gameService;
    private ShipService shipService;

    @BeforeEach
    void setUp() {
        Battlefield battlefield = new Battlefield();
        gameService = new BattleShipGameService(battlefield);
        shipService = new ShipService(battlefield);
    }

    // No duplicate missile fire
    @Test
    void testNoDuplicateMissileFiring() {
        gameService.initGame(6);
        shipService.addShip("SH1", 2, 1, 2, 4, 3);

        Battlefield battlefield = gameService.getBattlefield();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();

        battlefield.fireMissile(playerA, playerB);
        battlefield.fireMissile(playerA, playerB);

        // Ensure that the same coordinates were not fired twice
        assertEquals(2, battlefield.getFiredCoordinates().size());
    }
}
