package com.codecool.model.pony;

import com.codecool.model.ability.Fly;
import com.codecool.model.ability.Magic;
import com.codecool.model.ability.MagicType;
import com.codecool.model.Position;

public class SuperPony extends Pony implements Fly, Magic {
    public SuperPony(String name) {
        super(name);
    }

    @Override
    public Position fly(Position position) {
        this.setPosition(position);
        System.out.println("Pony flew to: " + position);
        return position;
    }
    @Override
    public void doMagic(int ordinal) {
        MagicType magicType = MagicType.getValues()[ordinal];
        this.increaseLevel();
        this.setName(getName() + " " + magicType.getSign());
        System.out.println("Evoking magical " + magicType.name());
    }
}
// DI,  a tulajdonság az lehetne egy osztály és azt DI-vel kapja meg.
// Todo: protected...