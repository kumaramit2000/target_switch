package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import com.phonepe.battleShipGame.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipServiceTest {

    private BattleShipGameService gameService;
    private ShipService shipService;

    @BeforeEach
    void setUp() {
        Battlefield battlefield = new Battlefield();
        gameService = new BattleShipGameService(battlefield);
        shipService = new ShipService(battlefield);
    }

    // Add a valid ship, ship must be added to both players
    @Test
    void testAddShip() {
        gameService.initGame(6);
        shipService.addShip("SH1", 2, 1, 2, 4, 3);

        Battlefield battlefield = gameService.getBattlefield();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();

        assertEquals(1, playerA.getShips().size());
        assertEquals(1, playerB.getShips().size());
    }

    // Adding a ship outside allowed area
    @Test
    void testAddShipOutsideArea() {
        gameService.initGame(6);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                // PlayerA's ship in PlayerB's area
                shipService.addShip("SH1", 2, 4, 3, 1, 2)
        );
        assertEquals("Ship placement outside allowed area for PlayerA", exception.getMessage());
    }

    // Adding an overlapping ship
    @Test
    void testAddOverlappingShip() {
        gameService.initGame(6);
        shipService.addShip("SH1", 2, 1, 2, 4, 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                // Overlaps with SH1
                shipService.addShip("SH2", 2, 1, 2, 5, 3)
        );
        assertEquals("Ship placement overlaps with an existing ship.", exception.getMessage());
    }

    // Destroying all ships for any player to ends the game
    @Test
    void testGameEndsWhenAllShipsDestroyed() {
        gameService.initGame(6);
        shipService.addShip("SH1", 2, 1, 2, 4, 1);
        shipService.addShip("SH2", 2, 1, 5, 5, 4);

        Battlefield battlefield = gameService.getBattlefield();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();

        while (!battlefield.isGameOver()) {
            battlefield.fireMissile(playerA, playerB);
        }
        assertTrue(battlefield.isGameOver());
    }
}
