package com.codecool.model.user;

import com.codecool.model.Position;
import com.codecool.model.pony.Pony;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class User {
//    private int count;
    private final String username;
    private final LocalDate registrationDate;
    private final List<Pony> ponies;

    private int highestPonyLevel;

    public User(String username, LocalDate registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
        this.highestPonyLevel = 0;
        this.ponies = new ArrayList<>();
//        this.count = 0;
    }

    public List<Pony> getPoniesAtPosition(Position position) {
        List<Pony> poniesAtPosition = new ArrayList<>();
        for (Pony pony : ponies) {
            if (pony.getPosition().equals(position)) {
                poniesAtPosition.add(pony);
            }
        }
        return poniesAtPosition;
    }

    public void addPony(Pony pony) {
        ponies.add(pony);
        // add overrrided!
//        count++;
//        if (highestPonyLevel < pony.getLevel()) {
//            this.highestPonyLevel = pony.getLevel();
//        }
        // a usernek mindig ki kell számolnia
    }

    public List<Pony> getAllPonies() {
        // return new!!! (ne copy of...)
        return new ArrayList<>(ponies);
    }

    public int getHighestLevelOfPonies() {
        OptionalInt maxLevel = ponies.stream()
                .mapToInt(Pony::getLevel)
                .max();
        return maxLevel.isPresent() ? maxLevel.getAsInt() : 0;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return username;
    }
}
