package com.udate.udate.menu;

import com.udate.udate.UDate;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuChoice> mainMenu;

    private ArrayList<MenuChoice> adminMenu;
    private ArrayList<MenuChoice> adminUsersMenu;
    private ArrayList<MenuChoice> adminHobbiesMenu;
    private ArrayList<MenuChoice> adminLocationsMenu;

    private ArrayList<MenuChoice> userMenu;
    private ArrayList<MenuChoice> userProfileMenu;
    private ArrayList<MenuChoice> userListMenu;
    private ArrayList<MenuChoice> userMatchMenu;
    private ArrayList<MenuChoice> userLikesMenu;

    private ArrayList<MenuChoice> currentMenu;

    public Menu(UDate p){
        mainMenu = new ArrayList<MenuChoice>();
        adminMenu = new ArrayList<MenuChoice>();
        adminUsersMenu = new ArrayList<MenuChoice>();
        adminHobbiesMenu = new ArrayList<MenuChoice>();
        adminLocationsMenu = new ArrayList<MenuChoice>();
        userMenu = new ArrayList<MenuChoice>();
        userProfileMenu = new ArrayList<MenuChoice>();
        userListMenu = new ArrayList<MenuChoice>();
        userLikesMenu = new ArrayList<MenuChoice>();

        mainMenu.add(new MenuChoice("Logga in admin", '1', this::loginAdmin, p));
        mainMenu.add(new MenuChoice("Logga in användare", '2', this::loginUser, p));
        mainMenu.add(new MenuChoice("Registrera ny användare", '3', this::createUser, p));
        mainMenu.add(new MenuChoice("Avsluta", '0', null));

        adminMenu.add(new MenuChoice("Hantera användare", '1', this::setMenu, adminUsersMenu));
        adminMenu.add(new MenuChoice("Hantera hobbies", '2', this::setMenu, adminHobbiesMenu));
        adminMenu.add(new MenuChoice("Hantera platser", '3', this::setMenu, adminLocationsMenu));
        adminMenu.add(new MenuChoice("Logga ut", '0', this::logoutAdmin, p));

        adminUsersMenu.add(new MenuChoice("Lägg till användare", '1', this::createUserAsAdmin, p));
        adminUsersMenu.add(new MenuChoice("Ta bort användare", '2', p::methodPlaceholder));
        adminUsersMenu.add(new MenuChoice("Redigera användare", '3', p::methodPlaceholder));
        adminUsersMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        adminHobbiesMenu.add(new MenuChoice("Lägg till hobby", '1', p::methodPlaceholder));
        adminHobbiesMenu.add(new MenuChoice("Ta bort hobby", '2', p::methodPlaceholder));
        adminHobbiesMenu.add(new MenuChoice("Redigera hobby", '3', p::methodPlaceholder));
        adminHobbiesMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        adminLocationsMenu.add(new MenuChoice("Lägg till plats", '1', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Ta bort plats", '2', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Redigera plats", '3', p::methodPlaceholder));
        adminLocationsMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, adminMenu));

        userMenu.add(new MenuChoice("Hantera profil", '1', this::setMenu, userProfileMenu));
        userMenu.add(new MenuChoice("Andra användare", '2', p::methodPlaceholder));
        userMenu.add(new MenuChoice("Se matchningar", '3', p::methodPlaceholder));
        userMenu.add(new MenuChoice("Se gilla-markeringar", '3', p::methodPlaceholder));
        userMenu.add(new MenuChoice("Logga ut", '0', this::logout, p));

        userProfileMenu.add(new MenuChoice("Redigera", '1', p::methodPlaceholder));
        userProfileMenu.add(new MenuChoice("Radera", '2', p::methodPlaceholder));
        userProfileMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));

        userListMenu.add(new MenuChoice("Sök användare", '1', p::methodPlaceholder, null));
        userListMenu.add(new MenuChoice("Lista användare", '2', p::methodPlaceholder, null));
        userListMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));

        userLikesMenu.add(new MenuChoice("Se vilka jag gillat", '1', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Se vilka som gillar mig", '2', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Vi gillar varandra! :)", '0', p::methodPlaceholder, null));
        userLikesMenu.add(new MenuChoice("Tillbaka", '0', this::setMenu, userMenu));

        currentMenu = mainMenu;
    }

    private void setMenu(Object o) {
        currentMenu = (ArrayList<MenuChoice>) o;
    }//showMainMenu

    private void createUser(Object o){
        if (((UDate)o).registerUser(true))
            setMenu(userMenu);
    }
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

    private void printMenu() {
        System.out.println("");
        for (MenuChoice m : currentMenu) {
            System.out.printf("%s%n", m.getFullTitle());
        } // for m...
        System.out.print("Ange ditt val: ");
    } // printMenu

    // Hämta användarens val
    private MenuChoice getMenuChoice() {
        String sChoice;
        Scanner scan = new Scanner(System.in);

        // Se till så att det finns ett menyval och inte en tomrad (blir så efter nextDouble)
        do
            sChoice = scan.nextLine();
        while (sChoice.length() == 0);

        // Loopa igenom och returnera rätt menyval
        for (MenuChoice m : currentMenu) {
            if (m.getKey() == sChoice.charAt(0))
                return m;
        } // for...
        return null;
    } // getMenuChoice

    public void handleMenu() {
        boolean bStop = false;
        String sChoice;
        MenuChoice m;
        while (!bStop) {
            printMenu();
            m = getMenuChoice();
            if (m == null)
                System.out.println("Felaktigt val, försök igen!");
            else {
                System.out.printf("Du valde: %s%n", m.getTitle());
                bStop = m.getFunctionToCall() == null;
                if (!bStop) {
                    m.getFunctionToCall().accept(m.getParameter());
                } // if bStop...
            } // else
        } // while
    } // handleMenu
} // class Menu
