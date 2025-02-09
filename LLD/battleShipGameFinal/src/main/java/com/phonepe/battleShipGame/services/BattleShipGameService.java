package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import com.phonepe.battleShipGame.models.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BattleShipGameService {
    private static final Logger logger = LoggerFactory.getLogger(BattleShipGameService.class);
    private Battlefield battlefield;

    public BattleShipGameService(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    /**
     * Initializes the game with a battlefield of specified size.
     * The size must be an even number and at least 2.
     * Left half of N/2xN will be assigned to Player A
     * And the right half will be assigned to Player B
     *
     * @param size the size of the battlefield
     * @throws IllegalArgumentException if the size is invalid
     */
    public synchronized void initGame(int size) {
        if (size < 2 || size % 2 != 0) {
            logger.error("Invalid battlefield size: {}. Size must be an even number and >= 2", size);
            throw new IllegalArgumentException("Battlefield size must be an even number and >= 2");
        }
        battlefield.initialize(size);
        logger.info("Game initialized successfully with battlefield size: {}", size);
        logPlayerArea(battlefield.getPlayerA());
        logPlayerArea(battlefield.getPlayerB());
    }

    private void logPlayerArea(Player player) {
        logger.info("{}'s area: ({},0) to ({}, {})", player.getName(), player.getMinX(), player.getMaxX(), battlefield.getSize());
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }
}