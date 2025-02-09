package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import com.phonepe.battleShipGame.models.Player;
import com.phonepe.battleShipGame.models.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    private static final Logger logger = LoggerFactory.getLogger(ShipService.class);
    private final Battlefield battlefield;

    public ShipService(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    /**
     * Adds a ship for both players on the battlefield.
     *
     * @param id   the ship's ID
     * @param size the size of the ship
     * @param xA   the x-coordinate of the ship for Player A
     * @param yA   the y-coordinate of the ship for Player A
     * @param xB   the x-coordinate of the ship for Player B
     * @param yB   the y-coordinate of the ship for Player B
     * @throws IllegalStateException      if the game hasn't been initialized
     * @throws IllegalArgumentException   if the ship placement is invalid or if the ships overlap
     */
    public synchronized void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        validateGameInitialized();
        Player playerA = battlefield.getPlayerA();
        Player playerB = battlefield.getPlayerB();
        Ship shipA = new Ship(id, size, xA, yA);
        Ship shipB = new Ship(id, size, xB, yB);
        logShipDetails(shipA,playerA);
        logShipDetails(shipB,playerB);
        validateShipPlacement(playerA, shipA);
        validateShipPlacement(playerB, shipB);
        playerA.addShip(shipA);
        playerB.addShip(shipB);
        logger.info("Ship {} added for both players.", id);
    }

    private synchronized  void validateShipPlacement(Player player, Ship newShip) {
        if (newShip.getX1() < player.getMinX() || newShip.getX2() > player.getMaxX()) {
            logger.error("Ship is going outside designated battlefield area for player {}",player.getName());
            throw new IllegalArgumentException("Ship placement outside allowed area for " + player.getName());
        }
        for (Ship existingShip : player.getShips()) {
            if (newShip.isOverlapping(existingShip)) {
                logger.error("Ship is overlapping with another ships in designated battlefield area for player {}", player.getName());
                throw new IllegalArgumentException("Ship placement overlaps with an existing ship.");
            }
        }
    }

    private void logShipDetails(Ship ship, Player player) {
        logger.info("Ship details for {} with id {}", player.getName(), ship.getId());
        logger.info("Ship center is ({}, {})", ship.getX(), ship.getY());
        logger.info("Ship coordinates are ({}, {}) to ({}, {})", ship.getX1(), ship.getY1(), ship.getX2(), ship.getY2());
    }

    private synchronized void validateGameInitialized() {
        if (battlefield == null) {
            logger.error("Game is not yet initialized!");
            throw new IllegalStateException("Game not initialized!");
        }
    }
}
