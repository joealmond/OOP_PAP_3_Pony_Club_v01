package com.codecool.model.pony;


import com.codecool.model.Direction;
import com.codecool.model.Position;

public class Pony {
    private String name;
    private Position position;
    private int level;
    private int LEVLEL_INCREASE_AMOUNT = 1;
    String type;

    public Pony(String name) {
        this.name = name;
        this.position = new Position(0, 0);
        this.level = 0;
        this.type = this.getClass().getSimpleName();
    }

    public Position walkTo(Direction direction) {
        Position newPosition = this.position.moveToDirection(direction);
        this.position = newPosition;
        System.out.println("Pony heading to " + direction.name());
        return newPosition;
    }

    public String getName() {
        System.out.println("Pony name changed to: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        System.out.print("Pony is @: ");
        return position.getPosition();
    }

    void setPosition(Position position) {
        this.position = position;
    }

    void increaseLevel() {
        this.level = level + LEVLEL_INCREASE_AMOUNT;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pony{" +
                "name='" + name + '\'' +
                "type='" + type + '\'' +
                ", position=" + position +
                ", level=" + level +
                '}';
    }
}