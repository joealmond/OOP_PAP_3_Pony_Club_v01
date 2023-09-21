package com.codecool.model.pony;


import com.codecool.model.Direction;
import com.codecool.model.Position;

public class Pony {
    protected String name;
    // a package pvt-el módosítások után nem tudjuk garantálni...
    protected Position position;
    private int level;
    private static final int LEVEL_INCREASE_AMOUNT = 1;
    // csak így konstans!!!
//    private String type;

    public Pony(String name) {
        this.name = name;
        this.position = new Position(0, 0);
        this.level = 0;
//        this.type = this.getClass().getSimpleName();
    }

    public void walkTo(Direction direction) {
        Position newPosition = this.position.getNextPosition(direction);
        this.position = newPosition;
        System.out.println("Pony heading to " + direction.name());
//        return newPosition;
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
        // PA-n nem kell sout..
        return position.getPosition();
    }

    void setPosition(Position position) {
        this.position = position;
    }

    void increaseLevel() {
        this.level += LEVEL_INCREASE_AMOUNT;
    }

    public int getLevel() {
        return level;
    }

//    public String getType() {
//        return type;
//    }

    @Override
    public String toString() {
        return "Pony{" +
                "name='" + name + '\'' +
//                "type='" + type + '\'' +
                ", position=" + position +
                ", level=" + level +
                '}';
    }
}