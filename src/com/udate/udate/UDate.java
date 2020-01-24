package com.udate.udate;

import com.udate.fs.Data;
import com.udate.fs.Table;
import com.udate.udate.fs.*;
import com.udate.udate.menu.HobbyMenu;
import com.udate.udate.menu.LocationMenu;
import com.udate.udate.menu.MainMenu;
import com.udate.udate.menu.ProfileMenu;


import java.lang.reflect.Array;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class UDate {

    private MainMenu m;
    private UDateDB db = new UDateDB();

    private User loggedinUser = null;
    private boolean adminOnline = false;

    public UDate() {
        m = new MainMenu(this);
    }

    public void run() {
        // run the main menu
        m.handleMenu();
    } // run

    private void addHobbies() {
    }

    public void searchUser() {
    }


    private void editHobby() {
    }

    public boolean loginUser() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vänligen ange ditt användarnamn: ");
        String sUser = scan.nextLine();

        ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, sUser);
        if (res.size() == 1) {
            loggedinUser = (User) res.get(0);
            System.out.printf("%nVälkommen %s!%n", loggedinUser.getName());
            return true;
        } // if res...

        System.out.println("Hmm, du har nog skrivit fel användarnamn. Testa att logga in igen");
        return false;
    } // loginUser

    public void logOutUser() {
        System.out.println(String.format("%s: du är nu utloggad - tack och hej!", loggedinUser.getName()));
        loggedinUser = null;
    }

    public void logOutAdmin() {
        System.out.println("Admin är nu utloggad - tack och hej!");
        adminOnline = false;
    } // logoutAdmin

    public void showHobbyMenu(){
       new HobbyMenu(this).handleMenu();
    } // showHobbyMenu

    public void addHobbyToLoggedinUser(Object o){
       printSortedHobbyList();
       System.out.print("Välj en hobby att lägga till: ");
       Scanner scan  = new Scanner(System.in);
       String hobby = scan.nextLine();
        ArrayList<Data> res = db.search(HobbyTable.TABLE_NAME, Hobby.NAME, hobby);
        if (res.size() > 0) {
            loggedinUser.addHobby(res.get(0).getID());
            loggedinUser.save();
        } else{
            System.out.println("Hittar ej hobbyn!");
        } // else
    } // addHobbyToLoggedinUser

    public void removeHobbyFromLoggedinUser(Object o){
        Scanner scan = new Scanner(System.in);
        User resolvedUser = (User)db.getResolvedData(loggedinUser);

        System.out.println("Dina nuvarande hobbies: " + resolvedUser.getHobbyList());

        System.out.print("Välj en hobby att ta bort: ");
        String hobby = scan.nextLine();
        if (resolvedUser.getHobbyList().contains(hobby)) {
            ArrayList<Data> res = db.search(HobbyTable.TABLE_NAME, Hobby.NAME, hobby);
            if (res.size() == 1) {
                loggedinUser.removeHobby(((Hobby)res.get(0)).getID());
                loggedinUser.save();
            } // if res...
        } else{
            System.out.println("Du gillar inte denna hobby (än)!");
        } // else
    } // removeHobbyFromLoggedinUser

    public boolean registerUser(boolean createAsUser) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Var god att ange ett användarnamn:");
        String userName = scan.nextLine();
        ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, userName);
        if (res.size() == 1) {
            System.out.println("Användarnamnet finns redan! Prova igen: ");
            return false;
        } // if res...

        System.out.print("Var god ange ditt namn: ");
        String name = scan.nextLine();
        System.out.print("Var god ange din stad: ");
        String city = scan.nextLine();
        System.out.print("Var god ange din email: ");
        String email = scan.nextLine();
        System.out.print("Var god ange ditt kön: ");
        String gender = scan.nextLine();
        System.out.print("Var god ange din ålder: ");
        String age = scan.nextLine();

        User newUser = new User(name, userName, city, email, "", gender, age);
        if (!db.addRecord(newUser))
            System.out.println("Fel vid sparning av användare");
        else{
            if (createAsUser){
                loggedinUser = newUser;
                showHobbyMenu();
                System.out.printf("%nHej %s! Välkommen till UDate", newUser.getName());
                return true;
            } //if boolean...
        } //else
        return false;
    } // registerUser

    public void editUser(Object o){
        Scanner scan = new Scanner(System.in);

        System.out.println(db.getResolvedData(loggedinUser));

        System.out.printf("Ange ditt namn [%s] (tom sträng behåller det gamla värdet): ", loggedinUser.getName());

        String input = scan.nextLine();
        if (!input.equals(""))
            loggedinUser.setName(input);

        System.out.printf("Ange din stad [%s] (tom sträng behåller det gamla värdet): ", loggedinUser.getCity());
        input = scan.nextLine();
        if (!input.equals(""))
            loggedinUser.setCity(input);

        System.out.printf("Ange din e-postadress [%s] (tom sträng behåller det gamla värdet): ", loggedinUser.getEmail());
        input = scan.nextLine();
        if (!input.equals(""))
            loggedinUser.setEmail(input);

        System.out.printf("Ange din ålder [%s] (tom sträng behåller det gamla värdet): ", loggedinUser.getAge());
        input = scan.nextLine();
        if (!input.equals(""))
            loggedinUser.setAge(input);

        System.out.printf("Ange ditt kön [%s] (tom sträng behåller det gamla värdet): ", loggedinUser.getGender());
        input = scan.nextLine();
        if (!input.equals(""))
            loggedinUser.setGender(input);

        loggedinUser.save();
        showHobbyMenu();
    } // editUser

    public boolean loginAdmin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vänligen ange admin-lösenordet: ");
//       Console con = System.console();
//        if(con == null)
//        {
//            System.out.print("No console available");
//            return;
//        }

        String sPwd = scan.nextLine();
//        String sPwd = con.readPassword().toString();
        if (sPwd.equals("12359")) {
            adminOnline = true;
            return true;
        } else {
            System.out.println("Fel lösenord - stick och brinn!");
            return false;
        } // else
    } // loginAdmin

    public void removeUserAsAdmin(Object o) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ange ett användarnamn att radera: ");
        String deleteUser = scan.nextLine();
        ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, deleteUser);
        if (res.size() == 1) {
            if (db.deleteRecord(res.get(0)))
                System.out.println(String.format("Användare '%s' raderad", deleteUser));
            else
                System.out.print(String.format("Användare '%s' kunde ej raderas", deleteUser));
        } // if res...
        else
            System.out.println("Användaren finns inte");
    } // removeUserAsAdmin

    public void addHobby(Object o){
        Scanner scan = new Scanner(System.in);

        System.out.print("Ange namn på hobbyn: ");
        String name = scan.nextLine();

        System.out.print("Beskriv hobbyn: ");
        String desc = scan.nextLine();

        Hobby hobby = new Hobby(name, desc, "");
        if (db.addRecord(hobby)){
            new LocationMenu(this, hobby).handleMenu();
            System.out.println(String.format("'%s' har blivit tillagd!", name));
        } // if db...
        else
            System.out.println("Kunde ej lägga till ny hobby!");
    } // addHobby

    private void printSortedHobbyList(){
        Map<String, Data> sorted = SortLists.sortHobbyListByName(db.getRecords(HobbyTable.TABLE_NAME));
        sorted.forEach((k, v) -> {
            System.out.printf("%s%n---------------------%n", db.getResolvedData((Hobby)v));
        });
    } // printSortedHobbyList

    public void deleteHobby(Object o){
        printSortedHobbyList();

        System.out.print("Ange hobby att radera: ");
        Scanner scan = new Scanner(System.in);
        String hobby = scan.nextLine();

        ArrayList<Data> res = db.search(HobbyTable.TABLE_NAME, Hobby.NAME, hobby);
        if (res.size() == 1) {
            if (db.deleteRecord(res.get(0)))
                System.out.println("Hobbyn raderad");
            else
                System.out.print(String.format("Hobby '%s' kunde ej raderas", hobby));
        } // if res...
        else
            System.out.println("Hobbyn finns inte");
    } // deleteHobby

    private void printSortedLocationList(){
        Map<String, Data> sorted = SortLists.sortLocationListByName(db.getRecords(LocationTable.TABLE_NAME));
        sorted.forEach((k, v) -> {
            System.out.printf("%s%n---------------------%n", v);
        });
    } // printSortedLocationList

    public void addLocationToHobby(Hobby hobby){
        printSortedLocationList();
        System.out.print("Välj en plats att lägga till: ");
        Scanner scan  = new Scanner(System.in);
        String location = scan.nextLine();
        ArrayList<Data> res = db.search(LocationTable.TABLE_NAME, Location.NAME, location);
        if (res.size() > 0) {
            hobby.addLocation(res.get(0).getID());
            hobby.save();
        } else{
            System.out.println("Hittar ej platsen!");
        } // else
    } // addLocationToHobby

    public void removeLocationToHobby(Hobby hobby){
        Scanner scan = new Scanner(System.in);
        Hobby resolvedHobby = (Hobby)(db.getResolvedData(hobby));
        System.out.println("Hobbyns nuvarande platser: " + resolvedHobby.getLocationList());

        System.out.print("Välj plats att ta bort: ");
        String location = scan.nextLine();
        if (resolvedHobby.getLocationList().contains(location)) {
            ArrayList<Data> res = db.search(LocationTable.TABLE_NAME, Location.NAME, location);
            if (res.size() == 1) {
                hobby.removeLocation(((Location)res.get(0)).getID());
                hobby.save();
            } // if res...
        } else{
            System.out.println("Den här platsen är inte tillagd till hobbyn (än)!");
        } // else
    } // removeLocationToHobby

    public void editHobby(Object o){
        printSortedHobbyList();

        System.out.print("Ange hobby att redigera: ");
        Scanner scan = new Scanner(System.in);
        String hobby = scan.nextLine();

        ArrayList<Data> res = db.search(HobbyTable.TABLE_NAME, Hobby.NAME, hobby);
        if (res.size() == 1) {
            Hobby hobbyRec = (Hobby)res.get(0);

            System.out.printf("Ange namn på hobbyn [%s] (tom sträng behåller det gamla värdet): ", hobbyRec.getName());

            String name = scan.nextLine();
            if (!name.equals(""))
                hobbyRec.setName(name);

            System.out.printf("Beskriv hobbyn [%s] (tom sträng behåller det gamla värdet): ", hobbyRec.getDescription());
            String desc = scan.nextLine();
            if (!desc.equals(""))
                hobbyRec.setDescription(desc);

            hobbyRec.save();
            new LocationMenu(this, hobbyRec).handleMenu();
        } // if res...
        else
            System.out.println("Hobbyn finns inte");
    } // editHobby

    public boolean removeLoggedUser(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ange ditt användarnamn för att radera: ");
        String deleteLoggedUser = scan.nextLine();
        if (deleteLoggedUser.equals(loggedinUser.getUsername())){
            ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, deleteLoggedUser);
            if (res.size() == 1) {
                if (db.deleteRecord(res.get(0))) {
                    System.out.println(String.format("Din användarprofil: '%s' är raderad", deleteLoggedUser));
                    loggedinUser = null;
                    return true;
                }
                else
                    System.out.print(String.format("Din användarprofil: '%s' kunde inte raderas", deleteLoggedUser));
            } // if res...
            else
                System.out.println("Användaren finns inte");
        }
        else System.out.println("Inte ditt användarnamn!");
        return false;
    };// removeUser

    public void adminAddLocation(Object o) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Skriv en plats du vill lägga till: ");
        String location = scan.nextLine();
        System.out.println("Skriv in adressen: ");
        String address = scan.nextLine();

        Location newLocation = new Location("", location, address);
        if (!db.addRecord(newLocation))
            System.out.println("Fel vid tillägg av en plats..");
        else{
            System.out.println("Platsen blev tillagd!");
        }
    }

    public void adminDeleteLocation(Object o) {
        HashMap<String, Data> recs = db.getRecords(LocationTable.TABLE_NAME);
        recs.forEach((k, v) ->System.out.println(v));

        Scanner scan = new Scanner(System.in);
        System.out.printf("Ange en plats du vill ta bort: ");
        String deleteLocation = scan.nextLine();

        ArrayList<Data> res = db.search(LocationTable.TABLE_NAME, Location.NAME, deleteLocation);
        if (res.size() > 0) {
            System.out.print("Det finns " + res.size() + " plats(er). Vill du verkligen radera? (Ja/Nej)");
            if (scan.nextLine().equals("Ja")) {
                for (Data d : res) {
                    if (db.deleteRecord(d))
                        System.out.print(String.format("Plats %s raderad", deleteLocation));
                    else
                        System.out.print(String.format("Plats %s kunde ej raderas", deleteLocation));
                }
            }
        }
        else System.out.println("Platsen finns inte");
    }

    public void adminEditLocation(Object o){
            HashMap<String, Data> recs = db.getRecords(LocationTable.TABLE_NAME);
            recs.forEach((k, v) -> System.out.println(v));

            System.out.print("Ange plats att redigera: ");
            Scanner scan = new Scanner(System.in);
            String location = scan.nextLine();

            ArrayList<Data> res = db.search(LocationTable.TABLE_NAME, Location.NAME, location);
            if (res.size() == 1) {
                Location locationRec = (Location)res.get(0);

                System.out.printf("Ange namn på platsen [%s] (tom sträng behåller det gamla värdet): ", locationRec.getName());
                String name = scan.nextLine();
                if (!name.equals(""))
                    locationRec.setName(name);

                System.out.printf("Ange addressen på platsen [%s] (tom sträng behåller det gamla värdet): ", locationRec.getAddress());
                String address = scan.nextLine();
                if (!address.equals(""))
                    locationRec.setAddress(address);
                locationRec.save();
            } // if res...
            else
                System.out.println("Platsen finns inte");
        } // editLocation

    public void methodPlaceholder(Object o) {
    }

    public void likeThisUser(Object o) {

        User likedUser = (User) o;
        Like lp = loggedinUser.hasLikedMe(db, likedUser);

        if (lp != null) {
            System.out.printf("\nDu har redan ♥ %s.\n", likedUser.getUsername());
        } else {

            lp = likedUser.hasLikedMe(db, loggedinUser);

            if (lp != null) {
                likedUser.likeBack(lp);
            } else {
                likedUser.likeUser(db, loggedinUser);
            }
        }
    }

    public void searchUser(Object o) {
        Scanner scanny = new Scanner(System.in);
        System.out.print("Sök användarnamn: ");
        String username = scanny.nextLine();

        ArrayList <Data> result = db.search(UserTable.TABLE_NAME, User.USERNAME, username);
        if (result.size() > 0){
            System.out.println(db.getResolvedData((User)result.get(0)));
            ProfileMenu pm = new ProfileMenu(this, (User)result.get(0));
            pm.handleMenu();
        }
        System.out.println("\nHittade ingen vid detta användarnamn.");
    }

    public void viewMyLikes(Object o) {
        String str = loggedinUser.getID();
        ArrayList<Data> result = db.search(LikeTable.TABLE_NAME, Like.USER_ID, str);
        if(result.size() > 0 ){
            System.out.println("listan e såhär lång: "+ result.size());
            for (Data lp : result) {
                if(((Like) lp).getLikedBack().equals("0")){
                    String likedUserId = ((Like) lp).getLikedUserId();
                    String userName = getUserNameFromId(likedUserId);
                    System.out.println(userName);
                }
            }

        }else{
            System.out.println("\nDu har inte gillat någon än");
        }

    }

    private String getUserNameFromId(String id) {
        ArrayList<Data> user = db.search(UserTable.TABLE_NAME, User.ID,id);
        return ((User) user.get(0)).getUsername();
    }

    public void likeEachOther(Object o) {
        ArrayList<Data> result = db.search(LikeTable.TABLE_NAME, Like.LIKED_BACK, "1");
        for (Data lp : result) {
            String user1 = ((Like) lp).getLikedUserId();
            String user2= ((Like) lp).getUserId();
            if( user1.equals(loggedinUser.getID()) || user2.equals(loggedinUser.getID())){
                System.out.printf("\n%s ♥ %s \n ",getUserNameFromId(user1), getUserNameFromId(user2));
            }
        }


    }

    public void viewWhoLikesMe(Object o) {
        ArrayList<Data> result = db.search(LikeTable.TABLE_NAME, Like.LIKES_USER_ID, loggedinUser.getID());
        int likeCounter = 0;

        if(result.size()>0){
            System.out.println();
            for (Data lp : result) {
                if(((Like) lp).getLikedBack().equals("0")) {
                    String userWhoLikedMe = ((Like) lp).getUserId();
                    String userName = getUserNameFromId(userWhoLikedMe);
                    System.out.println("♥" + userName);
                    likeCounter++;
                }
            }
        }
        if(likeCounter ==0 ){
            System.out.println("\nIngen som inte du också har gillat, gillar dig än!\n");
        }
    }
} // class UDate

