package com.codecool.model;

import java.util.Objects;

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

    public Position getNextPosition(Direction direction) {
        return new Position(this.x + direction.getXvalue(), this.y + direction.getYvalue());
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
// ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // A positionokat így tudjuk érték alapján összehasonlítani!!
}
