package com.phonepe.battleShipGame.models;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private Set<Ship> ships;
    private int minX, maxX; // Defines player's half of the battlefield
    private Set<String> firedMissiles;

    public Player(String name, int minX, int maxX) {
        this.name = name;
        this.ships = new HashSet<>();
        this.minX = minX;
        this.maxX = maxX;
        this.firedMissiles = new HashSet<>();
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }

    public boolean hasShips() {
        return !ships.isEmpty();
    }

    public boolean fireMissile(String target) {
        return firedMissiles.add(target); // Ensures no duplicate shots
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public String getName() {
        return name;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
}