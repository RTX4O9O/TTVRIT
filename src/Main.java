import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        MainWindow appwindow = new MainWindow();


    }
}



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static ArrayList<Profile> getProfilesFromJson(String jsonFilePath) {
        ArrayList<Profile> profileList = new ArrayList<>();
        Gson gson = new Gson();

        try {
            Type type = new TypeToken<Map<String, Profile>>(){}.getType();
            Map<String, Profile> profiles = gson.fromJson(new FileReader(jsonFilePath), type);
            
            for (Map.Entry<String, Profile> entry : profiles.entrySet()) {
                profileList.add(entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profileList;
    }

    // main method for testing
    public static void main(String[] args) {
        ArrayList<Profile> profiles = getProfilesFromJson("profiles.json");
        for (Profile profile : profiles) {
            System.out.println(profile.getName());
        }
    }
}