package com.udate.udate.menu;

import com.udate.udate.UDate;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends Menu {

    private ArrayList<MenuChoice> mainMenu = new ArrayList<MenuChoice>();

    private ArrayList<MenuChoice> adminMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> adminUsersMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> adminHobbiesMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> adminLocationsMenu = new ArrayList<MenuChoice>();

    private ArrayList<MenuChoice> userMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> userProfileMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> userListMenu = new ArrayList<MenuChoice>();
    private ArrayList<MenuChoice> userMatchMenu;
    private ArrayList<MenuChoice> userLikesMenu = new ArrayList<MenuChoice>();

    public MainMenu(UDate p){
        mainMenu.add(new MenuChoice("Logga in admin", '1', this::loginAdmin, p));
        mainMenu.add(new MenuChoice("Logga in användare", '2', this::loginUser, p));
        mainMenu.add(new MenuChoice("Registrera ny användare", '3', this::createUser, p));
        mainMenu.add(new MenuChoice("Avsluta", '0', null));

        adminMenu.add(new MenuChoice("Hantera användare", '1', this::setMenu, adminUsersMenu));
        adminMenu.add(new MenuChoice("Hantera hobbies", '2', this::setMenu, adminHobbiesMenu));
        adminMenu.add(new MenuChoice("Hantera platser", '3', this::setMenu, adminLocationsMenu));
        adminMenu.add(new MenuChoice("Logga ut", '0', this::logoutAdmin, p));

        adminUsersMenu.add(new MenuChoice("Lägg till användare", '1', this::createUserAsAdmin, p));
        adminUsersMenu.add(new MenuChoice("Ta bort användare", '2', p::removeUserAsAdmin));
        adminUsersMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        adminHobbiesMenu.add(new MenuChoice("Lägg till hobby", '1', p::addHobby));
        adminHobbiesMenu.add(new MenuChoice("Ta bort hobby", '2', p::deleteHobby));
        adminHobbiesMenu.add(new MenuChoice("Redigera hobby", '3', p::editHobby));
        adminHobbiesMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        adminLocationsMenu.add(new MenuChoice("Lägg till plats", '1', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Ta bort plats", '2', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Redigera plats", '3', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        userMenu.add(new MenuChoice("Hantera profil", '1', this::setMenu, userProfileMenu));
        userMenu.add(new MenuChoice("Hitta datingpartner", '2', this::setMenu, userListMenu));
        userMenu.add(new MenuChoice("Se matchningar", '3', p::methodPlaceholder));
        userMenu.add(new MenuChoice("Se gilla-markeringar", '3', p::methodPlaceholder));
        userMenu.add(new MenuChoice("Logga ut", '0', this::logout, p));

        userProfileMenu.add(new MenuChoice("Redigera", '1', p::methodPlaceholder));
        userProfileMenu.add(new MenuChoice("Radera", '2', p::methodPlaceholder));
        userProfileMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));

        userListMenu.add(new MenuChoice("Sök användare", '1', p::searchUser, null));
        userListMenu.add(new MenuChoice("Lista användare i din stad", '2', p::methodPlaceholder, null));
        userListMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));

        userLikesMenu.add(new MenuChoice("Se vilka jag gillat", '1', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Se vilka som gillar mig", '2', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Vi gillar varandra! :)", '0', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));
    }

    @Override
    public ArrayList<MenuChoice> setInitialMenu() {
        return mainMenu;
    } // setInitialMenu

    private void createUser(Object o){
        if (((UDate)o).registerUser(true))
            setMenu(userMenu);
    } // createUser

    private void createUserAsAdmin(Object o){
        ((UDate)o).registerUser(false);
    }

    private void logout(Object o){
        ((UDate)o).logOutUser();
        setMenu(mainMenu);
    } // Logout

    private void logoutAdmin(Object o){
        ((UDate)o).logOutAdmin();
        setMenu(mainMenu);
    } // Logout
    private void loginAdmin(Object o){
        if (((UDate)o).loginAdmin())
            setMenu(adminMenu);
    } // loginAdmin

    private void loginUser(Object o){
        if (((UDate)o).loginUser())
            setMenu(userMenu);
    } // loginUser

    private void removeLoggedUser(Object o){
        if (((UDate)o).removeLoggedUser())
            setMenu(mainMenu);
    }
} // class Menu
