package com.phonepe.battleShipGame.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Battlefield {
    private int size;
    private Player playerA;
    private Player playerB;
    private Set<String> firedCoordinates = new HashSet<>() ;  // Track fired missiles to prevent duplicates
    private static final Logger logger = LoggerFactory.getLogger(Battlefield.class);

    public void initialize(int size) {
        this.size = size;
        // Dividing Battlefield in half between both the players
        int mid = size / 2;
        this.playerA = new Player("PlayerA", 0, mid);  // Left half (0 to mid)
        this.playerB = new Player("PlayerB", mid, size);  // Right half (mid to size)
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public int getSize() {
        return size;
    }

    public Set<String> getFiredCoordinates() {
        return firedCoordinates;
    }

    /**
     * Each player will fire one missile towards the enemy field during his turn using the “random coordinate fire” strategy.
     * Handled, No two missiles should ever be fired at the same coordinates throughout the course of the game.
     * It may be possible, missile hit multiple Ships, in this case destroyed all those ships.
     * Hit or Miss the opponent ship case handled.
    */
    public void fireMissile(Player attacker, Player defender) {
        int x, y;
        String coordinate;
        int x1 = defender.getMinX();
        int x2 = defender.getMaxX();
        do {
            // Random X within defender's battlefield area
            x = ThreadLocalRandom.current().nextInt(x1, x2);
            // Random Y within defender's battlefield area
            y = ThreadLocalRandom.current().nextInt(0, size-1);
            coordinate = x + "," + y;
        } while (firedCoordinates.contains(coordinate));
        // Mark coordinate as fired
        firedCoordinates.add(coordinate);
        // Check if missile hits any ship
        List<Ship> hitShips = new ArrayList<>();
        for (Ship ship : defender.getShips()) {
            if (ship.isHit(x, y)) {
                hitShips.add(ship);
            }
        }
        if(hitShips.isEmpty()){
            logger.info("{}'s turn: Missile fired at ({},{}). MISS!",attacker.getName(),x,y);
        } else {
            for(Ship hitShip : hitShips){
                defender.getShips().remove(hitShip);
                logger.info("{}'s turn: Missile fired at ({},{}). HIT! {}'s ship with id {} destroyed.",attacker.getName(),x,y,defender.getName(), hitShip.getId());
            }
        }
    }

    public boolean isGameOver() {
        return !playerA.hasShips() || !playerB.hasShips();
    }

    public String viewBattleField() {
        // Create an empty NxN grid
        String[][] grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ".";
            }
        }
        for (Ship ship : playerA.getShips()) {
            markShipOnBattlefield(grid, ship, "A-" + ship.getId());
        }
        for (Ship ship : playerB.getShips()) {
            markShipOnBattlefield(grid, ship, "B-" + ship.getId());
        }
        return formBattleFieldView(grid);
    }

    private void markShipOnBattlefield(String[][] grid, Ship ship, String label) {
        for (int i = ship.getX1(); i < ship.getX2(); i++) {
            for (int j = ship.getY1(); j < ship.getY2(); j++) {
                // Ensure it's within given battlefield area
                if (i >= 0 && i < size && j >= 0 && j < size) {
                    grid[i][j] = label;
                }
            }
        }
    }

    /**
     * Logic for rotating Grid 90 degree anti-clockwise. because we took lower left as (0,0) as mentioned in PS.
     */
    private String formBattleFieldView(String[][] grid){
        int n = grid.length;
        String[][] rotatedGrid = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedGrid[n - 1 - j][i] = grid[i][j]; // Move rows to columns in reverse order
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%-6s", rotatedGrid[i][j])); // Align elements
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
