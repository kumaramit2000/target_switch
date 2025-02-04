package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import com.phonepe.battleShipGame.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleShipGameServiceTest {
    private BattleShipGameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new BattleShipGameService();
    }

    // Initialize game
    @Test
    void testInitGame() {
        gameService.initGame(6);
        Battlefield battlefield = gameService.getBattlefield();
        assertNotNull(battlefield);
        assertEquals(6, battlefield.getSize());
    }

    // Invalid game initialization means N value passed as Odd or <2.
    @Test
    void testInitGameInvalidSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameService.initGame(5));
        assertEquals("Battlefield size must be an even number and >= 2", exception.getMessage());
    }

    // Add a valid ship, ship must be added to both players
    @Test
    void testAddShip() {
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 2, 4, 3);

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
                gameService.addShip("SH1", 2, 4, 3, 1, 2)
        );
        assertEquals("Ship placement outside allowed area for PlayerA", exception.getMessage());
    }

    // Adding an overlapping ship
    @Test
    void testAddOverlappingShip() {
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 2, 4, 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                // Overlaps with SH1
                gameService.addShip("SH2", 2, 1, 2, 5, 3)
        );
        assertEquals("Ship placement overlaps with an existing ship.", exception.getMessage());
    }

    // No duplicate missile fire
    @Test
    void testNoDuplicateMissileFiring() {
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 2, 4, 3);

        Battlefield battlefield = gameService.getBattlefield();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();

        battlefield.fireMissile(playerA, playerB);
        battlefield.fireMissile(playerA, playerB);

        // Ensure that the same coordinates were not fired twice
        assertEquals(2, battlefield.getFiredCoordinates().size());
    }

    // Destroying all ships for any player to ends the game
    @Test
    void testGameEndsWhenAllShipsDestroyed() {
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 2, 4, 1);
        gameService.addShip("SH2", 2, 1, 5, 5, 4);

        Battlefield battlefield = gameService.getBattlefield();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();

        while (!battlefield.isGameOver()) {
            battlefield.fireMissile(playerA, playerB);
        }
        assertTrue(battlefield.isGameOver());
    }

    // Viewing battlefield displays correct grid
    @Test
    void testViewBattlefield() {
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 2, 4, 3);
        String battlefieldView = gameService.viewBattleField();
        assertNotNull(battlefieldView);
        assertTrue(battlefieldView.contains("A-SH1"));
        assertTrue(battlefieldView.contains("B-SH1"));
    }
}
