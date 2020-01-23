package com.udate.udate.menu;

import com.udate.udate.UDate;

import java.util.ArrayList;
import java.util.Scanner;

public class HobbyMenu extends Menu {

    private ArrayList<MenuChoice> mainMenu;

    public HobbyMenu(UDate p) {
        mainMenu = new ArrayList<MenuChoice>();

        mainMenu.add(new MenuChoice("Lägg till en hobby", '1', p::methodPlaceholder));
        mainMenu.add(new MenuChoice("Ta bort hobby", '2', p::methodPlaceholder));
        mainMenu.add(new MenuChoice("Tillbaka", '0', null));
        currentMenu = mainMenu;
    } // HobbyMEnu::HobbyMenu
} // class HobbyMenu