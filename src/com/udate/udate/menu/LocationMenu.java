package com.udate.udate.menu;

import com.udate.udate.UDate;
import com.udate.udate.fs.Hobby;

import java.util.ArrayList;

public class LocationMenu extends Menu {

    private ArrayList<MenuChoice> mainMenu;

    UDate app;

    public LocationMenu(UDate p, Hobby hobby) {
        app = p;
        mainMenu = new ArrayList<MenuChoice>();

        mainMenu.add(new MenuChoice("Lägg till en plats", '1', this::addHobby, hobby));
        mainMenu.add(new MenuChoice("Ta bort plats", '2', this::removeHobby, hobby));
        mainMenu.add(new MenuChoice("Tillbaka", '0', null));
    } // HobbyMenu::HobbyMenu

    @Override
    public ArrayList<MenuChoice> setInitialMenu() {
        return mainMenu;
    } // setInitialMenu

    private void addHobby(Object o){
        app.addLocationToHobby((Hobby)o);
    } // addHobby

    private void removeHobby(Object o){
        app.removeLocationToHobby((Hobby)o);
    } // removeHobby
} // class HobbyMenu