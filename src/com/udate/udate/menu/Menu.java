package com.udate.udate.menu;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Menu {
    protected ArrayList<MenuChoice> currentMenu;

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
