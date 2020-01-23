package com.udate.udate;

import com.udate.fs.Data;
import com.udate.fs.Reference;
import com.udate.udate.fs.*;
import com.udate.udate.menu.Menu;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class UDate {

    private Menu m;
    private UDateDB db = new UDateDB();

    private User loggedinUser = null;
    private boolean adminOnline = false;

//    private HobbyTable hobbyTable;
//    private LocationTable locationTable;
//    private UserTable userTable;

   public UDate(){
        m = new Menu(this);
//       createTables();
   }

    public void run() {

       m.handleMenu();
//        addHobbies();
//        addLocations();
//        createReference();
//        addUsers();
//        printAllPosts();
//        searchUser();
//        deleteLocation();
//        editHobby();
//        logInUser();
//        logOutUser();
    }

//    private void createTables() {
//       userTable = new UserTable();
//       locationTable = new LocationTable();
//       hobbyTable = new HobbyTable();
//    }

    private void addLocations() {
//        locationTable.addRecord("India", "India"); //byt ut sen
//        locationTable.addRecord("Malmö", "in the park");
//        locationTable.addRecord("Palace", "4th street");
//        locationTable.addRecord("Spa", "Åhus");
    }

    private void addHobbies() {
//        hobbyTable.addRecord("fishing", "lovely fishing in lake");
//        hobbyTable.addRecord("eat out", "lovely romantic dinner");
//        hobbyTable.addRecord("cricket", "nice game of cricket");
    }

//    private void createReference() {
//        userTable.addReference(new Reference(userTable, User.HOBBIES, Data.ID, Hobby.NAME));
//    }


    /*private void addUsers() {
        userTable.addRecord("Snehal", "snehalLovesYou", "malmövägen",
                "malmö", "34567", "snehal@gmail.com", " ", "f", "25");
        userTable.addRecord("Janis", "janisIsGreat", "bjuvvägeen",
                "bjuv", "34567", "janis@awesome.com", " ", "m", "45");

    }*/

//    private void printAllPosts() {
//       hobbyTable.getRecords();
//    }

    private void searchUser() {

    }

    private void deleteLocation() {
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
            System.out.println(String.format("Välkommen %s!", loggedinUser.getName()));
            return true;
        } // if res...

        System.out.println("Fel lösenord - stick och brinn!");
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

    public boolean registerUser(Object o) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Var god att ange ett användarnamn:");
        String userName = scan.nextLine();
        ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, userName);
        if (res.size() == 1) {
            System.out.println("Användarnamnet finns redan! Prova igen: ");
            return false;
        }

        System.out.print("Var god att ange ditt namn: ");
        String name = scan.nextLine();
        System.out.print("Var god att ange din stad: ");
        String city = scan.nextLine();
        System.out.print("Var god att ange din email: ");
        String email = scan.nextLine();
        System.out.print("Var god att ange ditt kön: ");
        String gender = scan.nextLine();
        System.out.print("Var god att ange din ålder: ");
        String age = scan.nextLine();

//        addHobbies();
        User newUser= new  User(name, userName, city, email, "", gender, age);
        if(!db.addRecord(newUser))
            System.out.println("Fel vid sparning av användare");
        else{
            if((Boolean)o){
                System.out.println(String.format("Hej %s! Välkommen till UDate", newUser.getName()));
                loggedinUser = newUser;
                return true;
            } //if boolean...
        } //else
        return false;
   }

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
       }
       else{
           System.out.println("Fel lösenord - stick och brinn!");
           return false;
       } // else
    } // loginAdmin

    public void removeUserAsAdmin(Object o){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ange ett användarnamn att radera:");
        String deleteUser = scan.nextLine();
        ArrayList<Data> res = db.search(UserTable.TABLE_NAME, User.USERNAME, deleteUser);
        if (res.size() == 1) {
        }
    }

    public void adminAddLocation(Object o) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Skriv en plats du vill lägga till: ");
        String location = scan.nextLine();
        System.out.println("Skriv in adressen: ");
        String address = scan.nextLine();

        Location newLocation = new Location("", location, address);
        if (!db.addRecord(newLocation))
            System.out.println("Fel vid sparning av användare");
    }

    public void methodPlaceholder(Object o) {
    }
}
