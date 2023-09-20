package com.codecool.model.user;

import com.codecool.model.pony.SuperPony;
import com.codecool.view.UiControl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Register {
    int count = 0;
    private String username;
    private LocalDate registrationDate;
    private List<User> users;

    public Register() {
        this.users = new ArrayList<>();
    }

    public User addUser(String username) {
        User newUser = new User(username, LocalDate.now());
        addPonyIfMontAugust(newUser);
        this.users.add(count, newUser);
        count++;
        return newUser;
    }

    public User addUser(String username, LocalDate registrationDate) {
        User newUser = new User(username, registrationDate);
        addPonyIfMontAugust(newUser);
        this.users.add(count, newUser);
        count++;
        return newUser;
    }

    private static void addPonyIfMontAugust(User user) {
        LocalDate registrationDate = user.getRegistrationDate();
        if (registrationDate.getMonth() == Month.AUGUST) {
            user.addPony(new SuperPony(UiControl.getNameInput("pony")));
        }
    }

    public User getUserWithHighestLevelPony(List<User> users) {
        Optional<User> userWithMaxLevelPony = users.stream().max(Comparator.comparingInt(User::getHighestLevelOfPonies));
        return userWithMaxLevelPony.orElseThrow(() -> new RuntimeException("No user found.."));
    }

    public int getUserCount() {
        System.out.println(count + " user/users registered.");
        return this.count;
    }

    public User getNthUser(int n) {
        User user = this.users.get(n);
        System.out.println("The " + n + ". user called: " + user);
        return user;
    }
}
