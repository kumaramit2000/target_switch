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
        Battlefield battlefield = new Battlefield();
        gameService = new BattleShipGameService(battlefield);
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
}
