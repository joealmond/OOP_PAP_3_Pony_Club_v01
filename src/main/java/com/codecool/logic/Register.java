package com.codecool.logic;

import com.codecool.model.Position;
import com.codecool.model.pony.Pony;
import com.codecool.model.pony.SuperPony;
import com.codecool.model.user.User;
import com.codecool.view.UiControl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Register {
    // aggregátor osztály szükséges, jobb elnevezés: PonyClub
//    int count = 0;
    private String username;
    private LocalDate registrationDate;
    private List<User> users;

    public Register() {
        this.users = new ArrayList<>();
    }

    public List<Pony> getPoniesAtPosition(Position position) {
        List<Pony> poniesAtPosition = new ArrayList<>();
        for (User user : users) {
            poniesAtPosition.addAll(user.getPoniesAtPosition(position));
        }
        return poniesAtPosition;
    }
    public void addUser(String username) {
        User newUser = new User(username, LocalDate.now());
        addPonyIfMontAugust(newUser);
        this.users.add(newUser);
//        count++;
//        return newUser;
    }

    public void addUser(String username, LocalDate registrationDate) {
        User newUser = new User(username, registrationDate);
        addPonyIfMontAugust(newUser);
        this.users.add(newUser);
//        count++;
//        return newUser;
    }

    private void addPonyIfMontAugust(User user) {
        LocalDate registrationDate = user.getRegistrationDate();
        if (registrationDate.getMonth() == Month.AUGUST) {
            user.addPony(new SuperPony(UiControl.getNameInput("pony")));
        }
        // ne legyen static
    }

    public User getUserWithHighestLevelPony() {
        Optional<User> userWithMaxLevelPony = users.stream()
                .max(Comparator.comparingInt(User::getHighestLevelOfPonies));
        return userWithMaxLevelPony.orElseThrow(() -> new RuntimeException("No user found.."));
    }

    public int getUserCount() {
        System.out.println(users.size() + " user/users registered.");
        return this.users.size();
    }

    public User getNthUser(int n) {
        User user = this.users.get(n);
        System.out.println("The " + n + ". user called: " + user);
        return user;
        // nem kérte a feladat
    }
}
