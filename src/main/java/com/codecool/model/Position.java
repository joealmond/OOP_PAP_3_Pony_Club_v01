package com.codecool.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getPosition() {
        System.out.println("x: " + this.x + "; y: " + this.y + ";");
        return new Position(this.x,this.y);
    }

    public Position moveToDirection(Direction direction) {
        return new Position(this.x + direction.getXvalue(), this.y + direction.getYvalue());
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
