package com.codecool.model.user;

import com.codecool.model.pony.Pony;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class User {
    int count;
    private final String username;
    private final LocalDate registrationDate;
    private final List<Pony> ponies;

    private int highestLevelPony;

    public User(String username, LocalDate registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
        this.highestLevelPony = 0;
        this.ponies = new ArrayList<>();
        this.count = 0;
    }

    public void addPony(Pony pony) {
        ponies.add(count, pony);
        count++;
        if (highestLevelPony < pony.getLevel()) {
            this.highestLevelPony = pony.getLevel();
        }
    }

    public List<Pony> getAllPonies() {
        return ponies;
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
