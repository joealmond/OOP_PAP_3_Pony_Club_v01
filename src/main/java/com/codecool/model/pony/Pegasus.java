package com.codecool.model.pony;

import com.codecool.model.ability.Fly;
import com.codecool.model.Position;

public class Pegasus extends Pony implements Fly {
    public Pegasus(String name) {
        super(name);
    }

    @Override
    public Position fly(Position position) {
        this.setPosition(position);
        System.out.println("Pony flew to: " + position);
        return position;
    }
}
