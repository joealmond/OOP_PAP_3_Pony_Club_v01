package com.codecool.view;

import com.codecool.model.pony.Pegasus;
import com.codecool.model.pony.Pony;
import com.codecool.model.pony.SuperPony;
import com.codecool.model.pony.Unicorn;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class UiControl {
    static private final Scanner scanner = new Scanner(System.in);

    public static String getNameInput(String type) {
        System.out.print("Enter name for " + type + ": ");
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static LocalDate getDateInput() {
        LocalDate date = null;
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String userInput = scanner.nextLine();
        try {
            date = LocalDate.parse(userInput);
        } catch (DateTimeParseException e) {
            System.out.println("Please enter the date in format: 'yyyy-MM-dd'! ");
            date = getDateInput();
        }
        return date;
    }

    public static int getPonyType() {
        System.out.println("1. Pony");
        System.out.println("2. Unicorn");
        System.out.println("3. Pegasus");
        System.out.println("4. SuperPony");
        System.out.print("Enter your choice: ");
        try {
            int userInput = Integer.parseInt(scanner.nextLine());
            return userInput;
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid integer from the list!");
            return getPonyType();
        }
    }

    public static <T> void printAll(List<T> items) {
        items.stream().forEach(System.out::println);
    }

    public static Pony createPony() {
        String ponyName = getNameInput("pony");
        int ponyType = getPonyType();
        Pony pony = switch (ponyType) {
            case 1 -> new Pony(ponyName);
            case 2 -> new Unicorn(ponyName);
            case 3 -> new Pegasus(ponyName);
            case 4 -> new SuperPony(ponyName);
            default -> null;
        };
        return pony;
    }
}
