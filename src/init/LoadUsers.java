package init;

import com.udate.udate.fs.Hobby;
import com.udate.udate.fs.HobbyTable;
import com.udate.udate.fs.User;
import com.udate.udate.fs.UserTable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


class Main {
    public static void main(String[] args) throws InterruptedException {

        LoadUsers loadUsers = new LoadUsers();

    }
}

public class LoadUsers {

    UserTable userTable = new UserTable();
    HobbyTable hobbyTable = new HobbyTable();


    public LoadUsers() throws InterruptedException {
        createHobbies();
        createUsers();

    }

    private void createHobbies() throws InterruptedException {
        hobbyTable.addRecord(new Hobby("Go-cart", "Drive the car and go!", "location/1579093279714.row"));
        Thread.sleep(2);
        hobbyTable.addRecord(new Hobby("Football", "Get sweaty on the grass!", "location/1579093279741.row"));
        Thread.sleep(2);
        hobbyTable.addRecord(new Hobby("Discgolf", "Like golf but much more fun!", "location/1579093279771.row, 1579093279756.row, location/1579093279778.row"));
        Thread.sleep(2);
        hobbyTable.addRecord(new Hobby("Cricket", "Cricket is fun to play but also fun to watch!", "location/1579093279756.row, 1579093279756.row, 1579093279764.row"));
        Thread.sleep(2);
        hobbyTable.addRecord(new Hobby("Karaoke", "Sing your heart out!", "location/1579093279797.row, location/1579093279790.row"));
        Thread.sleep(2);
        hobbyTable.addRecord(new Hobby("Eat out", "Romantic dinner or quick bite?", "location/1579093279784.row, location/1579093279805.row"));

    }

    private void createUsers(){

        String csvFile = "MOCK_DATA.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] userLine = line.split(cvsSplitBy);
                User user = new User(userLine[0], userLine[1], userLine[2], userLine[3], getRandomHobby(), userLine[5], userLine[6]);
                if(!userTable.addRecord(user));
                user.addHobby(getRandomHobby());
                //TODO lägg till fler hobbies, även i hobbylistan. check if unique
                user.save();
                Thread.sleep(2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getRandomHobby(){

        HashMap hobbies = hobbyTable.getRecords();

        ArrayList<String> keys = new ArrayList<>();

        hobbies.forEach((key, d) -> {

            keys.add((String) key);

        });

        int index = (int) Math.floor(Math.random() * 7);
        String randomHobby = keys.get(index);

        return randomHobby;
    }


}



