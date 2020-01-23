package com.udate.udate.menu;
import com.udate.fs.Data;
import com.udate.udate.UDate;
import com.udate.udate.fs.User;

import java.util.ArrayList;

    public class ProfileMenu extends Menu {

        private ArrayList<MenuChoice> mainMenu;

        public ProfileMenu(UDate p, User userToLike) {

            mainMenu = new ArrayList<MenuChoice>();


            mainMenu.add(new MenuChoice("Gilla den här användaren", '1', p::likeThisUser, userToLike));
            //om anv gillat dig, se utskrift på det, förslag: gilla tillbaks?
            mainMenu.add(new MenuChoice("Tillbaka", '0', null));
            currentMenu = mainMenu;
        }

        public ProfileMenu(UDate uDate) {
            super();
        }
    }

