package com.phonepe.battleShipGame.models;

public class Ship {
    private String id;
    private int size;
    private int x, y;  // Center coordinates
    private int x1, y1, x2, y2;  // Corner coordinates

    public Ship(String id, int size, int x, int y) {
        this.id = id;
        this.size = size;
        this.x = x;
        this.y = y;
        // Calculate top-left and bottom-right corners
        this.x1 = x - size / 2;
        this.y1 = y - size / 2;
        this.x2 = x + size / 2;
        this.y2 = y + size / 2;
    }

    public boolean isOverlapping(Ship other) {
        // Check if the current ship's area overlaps with another ship's area
        return this.x1 <= other.x2 && this.x2 >= other.x1 &&
                this.y1 <= other.y2 && this.y2 >= other.y1;
    }

    public boolean isHit(int missileX, int missileY) {
        return missileX >= x1 && missileX <= x2 && missileY >= y1 && missileY <= y2;
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}