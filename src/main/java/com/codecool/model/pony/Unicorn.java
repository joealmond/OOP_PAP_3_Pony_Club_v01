package com.codecool.model.pony;

import com.codecool.model.ability.Magic;
import com.codecool.model.ability.MagicType;

public class Unicorn extends Pony implements Magic {

    public Unicorn(String name) {
        super(name);
    }

    @Override
    public void doMagic(int ordinal) {
        MagicType magicType = MagicType.getValues()[ordinal];
        this.increaseLevel();
        name = name + " " + magicType.getSign();
        // protected !!!
        System.out.println("Evoking magical " + magicType.name());
    }
}
