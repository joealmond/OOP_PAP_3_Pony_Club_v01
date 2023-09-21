package com.codecool;

import com.codecool.model.*;
import com.codecool.model.pony.Pegasus;
import com.codecool.model.pony.Pony;
import com.codecool.model.pony.SuperPony;
import com.codecool.model.pony.Unicorn;
import com.codecool.logic.Register;
import com.codecool.model.user.User;
import com.codecool.view.UiControl;

import java.util.List;

import static com.codecool.model.Direction.*;

public class App {
    public static void main(String[] args) {
        Pony buckoo = new Pony("Buckó");
        buckoo.getPosition();
        buckoo.walkTo(NORTH);
        buckoo.getPosition();
        buckoo.walkTo(EAST);
        buckoo.getPosition();
        buckoo.getName();
        buckoo.setName("Buckoo");
        buckoo.getName();

        Pegasus barbie = new Pegasus("Barbie");
        barbie.getPosition();
        barbie.fly(new Position(3,3));
        barbie.getPosition();

        Unicorn unionRainbow = new Unicorn("Uion Rainbow");
        unionRainbow.doMagic(1);
        unionRainbow.doMagic(0);
        unionRainbow.getName();
        unionRainbow.walkTo(SOUTH);
        unionRainbow.getPosition();

        SuperPony ultraRainbow = new SuperPony("Ultra Rainbow");
        ultraRainbow.getName();
        ultraRainbow.getPosition();
        ultraRainbow.doMagic(2);
        ultraRainbow.getName();
        ultraRainbow.fly(new Position(4,4));
        ultraRainbow.walkTo(EAST);
        ultraRainbow.getPosition();

        Register register = new Register();
        register.addUser(UiControl.getNameInput("user"));
        register.addUser(UiControl.getNameInput("user"),UiControl.getDateInput());
        register.getUserCount();
        User nthUser = register.getNthUser(1);
        nthUser.addPony(UiControl.createPony());
        List<Pony> allPonies = nthUser.getAllPonies();
        UiControl.printAll(allPonies);
    }

}